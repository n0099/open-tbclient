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
/* loaded from: classes11.dex */
public class h extends d implements View.OnClickListener {
    private CustomMessageListener jhU;
    private boolean jnP;
    private com.baidu.tieba.personPolymeric.c.a jnQ;
    private PersonChangeData jnR;
    private HttpMessageListener jnS;
    private HttpMessageListener jnT;
    private Runnable jnU;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private final WriteImagesInfo writeImagesInfo;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.jnP = true;
        this.jnS = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    h.this.cwW();
                }
            }
        };
        this.jnT = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        h.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        h.this.cwW();
                    }
                }
            }
        };
        this.jnU = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.jhU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    h.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jhU.setTag(bdUniqueId);
        this.jnT.setTag(bdUniqueId);
        this.jnS.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.jhU);
        this.mPageContext.registerListener(this.jnT);
        this.mPageContext.registerListener(this.jnS);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jnQ = aVar;
    }

    public List<m> cwQ() {
        if (this.jnQ == null) {
            return null;
        }
        return this.jnQ.cwQ();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && cwQ() != null) {
            m mVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                mVar = ((com.baidu.tieba.person.b.c) view.getTag()).aIv();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                mVar = ((com.baidu.tieba.person.b.b) view.getTag()).aIv();
            }
            int position = v.getPosition(cwQ(), mVar);
            if (position >= 0) {
                a(mVar, cwQ(), position);
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
            if (this.jnQ != null) {
                this.mIsHost = this.jnQ.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (mVar instanceof n) {
                    c((n) mVar, list, i);
                }
            } else if (mVar instanceof com.baidu.tieba.person.data.c) {
                cwU();
            } else if (mVar instanceof n) {
                n nVar = (n) mVar;
                if (nVar.aNY()) {
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

    private void cwU() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    h.this.jnP = false;
                    switch (i) {
                        case 0:
                            h.this.cwX();
                            break;
                        case 1:
                            h.this.cwY();
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
                    h.this.jnP = true;
                    switch (i2) {
                        case 0:
                            h.this.c(nVar, list, i);
                            break;
                        case 1:
                            if (h.this.mIsHost && h.this.jnQ != null && h.this.jnQ.getUserData() != null && !h.this.jnQ.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jnQ.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.jnQ.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cwX();
                                break;
                            }
                            break;
                        case 2:
                            if (h.this.mIsHost && h.this.jnQ != null && h.this.jnQ.getUserData() != null && !h.this.jnQ.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jnQ.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.jnQ.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cwY();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").X("obj_type", 1));
                            h.this.cwZ();
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
        if (this.mPageContext != null && nVar != null && list != null && !StringUtils.isNull(nVar.aNX())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (m mVar : list) {
                if (mVar instanceof n) {
                    n nVar2 = (n) mVar;
                    if (nVar2.aNY() && !nVar2.aNX().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(i.d(this.mPageContext, nVar2.aNX()));
                    } else {
                        arrayList.add(nVar2.aNX());
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.jnP)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void cwV() {
        if (this.jnQ != null && this.jnQ.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.aPO().deletePhoto(this.jnQ.getUserData().getPortrait());
        }
    }

    public void cwW() {
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jnU, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.jnQ != null && this.jnQ.getUserData() != null && this.jnQ.isHost() && personChangeData.getPhotoChanged()) {
            if (this.jnR == null) {
                this.jnR = new PersonChangeData();
            }
            this.jnR.setPhotoChanged(true);
            cwV();
        }
    }

    public void cwX() {
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

    public void cwY() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.jnP)));
        }
    }

    public void cwZ() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jnU);
    }
}
