package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class h extends d implements View.OnClickListener {
    private CustomMessageListener jgW;
    private boolean jmR;
    private com.baidu.tieba.personPolymeric.c.a jmS;
    private PersonChangeData jmT;
    private HttpMessageListener jmU;
    private HttpMessageListener jmV;
    private Runnable jmW;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private final WriteImagesInfo writeImagesInfo;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.jmR = true;
        this.jmU = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    h.this.cvB();
                }
            }
        };
        this.jmV = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        h.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        h.this.cvB();
                    }
                }
            }
        };
        this.jmW = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.jgW = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    h.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jgW.setTag(bdUniqueId);
        this.jmV.setTag(bdUniqueId);
        this.jmU.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.jgW);
        this.mPageContext.registerListener(this.jmV);
        this.mPageContext.registerListener(this.jmU);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jmS = aVar;
    }

    public List<m> cvv() {
        if (this.jmS == null) {
            return null;
        }
        return this.jmS.cvv();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && cvv() != null) {
            m mVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                mVar = ((com.baidu.tieba.person.b.c) view.getTag()).aGg();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                mVar = ((com.baidu.tieba.person.b.b) view.getTag()).aGg();
            }
            int position = v.getPosition(cvv(), mVar);
            if (position >= 0) {
                a(mVar, cvv(), position);
            }
        }
    }

    public void a(m mVar, List<m> list, int i, boolean z) {
        if (mVar != null) {
            if (z) {
                if (mVar instanceof n) {
                    c((n) mVar, list, i);
                    return;
                }
                return;
            }
            if (this.jmS != null) {
                this.mIsHost = this.jmS.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (mVar instanceof n) {
                    c((n) mVar, list, i);
                }
            } else if (mVar instanceof com.baidu.tieba.person.data.c) {
                cvz();
            } else if (mVar instanceof n) {
                n nVar = (n) mVar;
                if (nVar.aLC()) {
                    a(nVar, list, i);
                } else {
                    b(nVar, list, i);
                }
            }
        }
    }

    public void a(m mVar, List<m> list, int i) {
        a(mVar, list, i, false);
    }

    private void cvz() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    h.this.jmR = false;
                    switch (i) {
                        case 0:
                            h.this.cvC();
                            break;
                        case 1:
                            h.this.cvD();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.showDialog();
        }
    }

    private void a(final n nVar, final List<m> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    h.this.jmR = true;
                    switch (i2) {
                        case 0:
                            h.this.c(nVar, list, i);
                            break;
                        case 1:
                            if (h.this.mIsHost && h.this.jmS != null && h.this.jmS.getUserData() != null && !h.this.jmS.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jmS.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.jmS.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cvC();
                                break;
                            }
                            break;
                        case 2:
                            if (h.this.mIsHost && h.this.jmS != null && h.this.jmS.getUserData() != null && !h.this.jmS.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jmS.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.jmS.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cvD();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").Z("obj_type", 1));
                            h.this.cvE();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.showDialog();
        }
    }

    private void b(final n nVar, final List<m> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        h.this.c(nVar, list, i);
                        break;
                    case 1:
                        i.a(nVar, h.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        i.a(nVar, list);
                        break;
                }
                if (iVar.isShowing()) {
                    iVar.dismiss();
                }
            }
        });
        iVar.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar, List<m> list, int i) {
        if (this.mPageContext != null && nVar != null && list != null && !StringUtils.isNull(nVar.aLB())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (m mVar : list) {
                if (mVar instanceof n) {
                    n nVar2 = (n) mVar;
                    if (nVar2.aLC() && !nVar2.aLB().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(i.d(this.mPageContext, nVar2.aLB()));
                    } else {
                        arrayList.add(nVar2.aLB());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true).setIsShowHost(false)));
        }
    }

    public void ap(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.jmR)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void cvA() {
        if (this.jmS != null && this.jmS.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.aNs().deletePhoto(this.jmS.getUserData().getPortrait());
        }
    }

    public void cvB() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jmW, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.jmS != null && this.jmS.getUserData() != null && this.jmS.isHost() && personChangeData.getPhotoChanged()) {
            if (this.jmT == null) {
                this.jmT = new PersonChangeData();
            }
            this.jmT.setPhotoChanged(true);
            cvA();
        }
    }

    public void cvC() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    }

    public void cvD() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.jmR)));
        }
    }

    public void cvE() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jmW);
    }
}
