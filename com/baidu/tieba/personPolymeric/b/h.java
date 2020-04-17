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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class h extends d implements View.OnClickListener {
    private CustomMessageListener jTU;
    private boolean jZQ;
    private com.baidu.tieba.personPolymeric.c.a jZR;
    private PersonChangeData jZS;
    private HttpMessageListener jZT;
    private HttpMessageListener jZU;
    private Runnable jZV;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private final WriteImagesInfo writeImagesInfo;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.jZQ = true;
        this.jZT = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    h.this.cId();
                }
            }
        };
        this.jZU = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        h.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        h.this.cId();
                    }
                }
            }
        };
        this.jZV = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.jTU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    h.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jTU.setTag(bdUniqueId);
        this.jZU.setTag(bdUniqueId);
        this.jZT.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.jTU);
        this.mPageContext.registerListener(this.jZU);
        this.mPageContext.registerListener(this.jZT);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.jZR = aVar;
    }

    public List<m> cHX() {
        if (this.jZR == null) {
            return null;
        }
        return this.jZR.cHX();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && cHX() != null) {
            m mVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                mVar = ((com.baidu.tieba.person.b.c) view.getTag()).aQY();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                mVar = ((com.baidu.tieba.person.b.b) view.getTag()).aQY();
            }
            int position = v.getPosition(cHX(), mVar);
            if (position >= 0) {
                a(mVar, cHX(), position);
            }
        }
    }

    public void a(m mVar, List<m> list, int i, boolean z) {
        if (mVar != null) {
            if (z) {
                if (mVar instanceof l) {
                    c((l) mVar, list, i);
                    return;
                }
                return;
            }
            if (this.jZR != null) {
                this.mIsHost = this.jZR.isHost();
            }
            if (!com.baidu.adp.lib.util.l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (mVar instanceof l) {
                    c((l) mVar, list, i);
                }
            } else if (mVar instanceof com.baidu.tieba.person.data.c) {
                cIb();
            } else if (mVar instanceof l) {
                l lVar = (l) mVar;
                if (lVar.aWw()) {
                    a(lVar, list, i);
                } else {
                    b(lVar, list, i);
                }
            }
        }
    }

    public void a(m mVar, List<m> list, int i) {
        a(mVar, list, i, false);
    }

    private void cIb() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    h.this.jZQ = false;
                    switch (i) {
                        case 0:
                            h.this.cIe();
                            break;
                        case 1:
                            h.this.cIf();
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

    private void a(final l lVar, final List<m> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    h.this.jZQ = true;
                    switch (i2) {
                        case 0:
                            h.this.c(lVar, list, i);
                            break;
                        case 1:
                            if (h.this.mIsHost && h.this.jZR != null && h.this.jZR.getUserData() != null && !h.this.jZR.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jZR.getUserData().getCantModifyAvatarDesc())) {
                                    com.baidu.adp.lib.util.l.showLongToast(TbadkCoreApplication.getInst(), h.this.jZR.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    com.baidu.adp.lib.util.l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cIe();
                                break;
                            }
                            break;
                        case 2:
                            if (h.this.mIsHost && h.this.jZR != null && h.this.jZR.getUserData() != null && !h.this.jZR.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.jZR.getUserData().getCantModifyAvatarDesc())) {
                                    com.baidu.adp.lib.util.l.showLongToast(TbadkCoreApplication.getInst(), h.this.jZR.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    com.baidu.adp.lib.util.l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cIf();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").af("obj_type", 1));
                            h.this.cIg();
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

    private void b(final l lVar, final List<m> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        h.this.c(lVar, list, i);
                        break;
                    case 1:
                        i.a(lVar, h.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        i.a(lVar, list);
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
    public void c(l lVar, List<m> list, int i) {
        if (this.mPageContext != null && lVar != null && list != null && !StringUtils.isNull(lVar.aWv())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (m mVar : list) {
                if (mVar instanceof l) {
                    l lVar2 = (l) mVar;
                    if (lVar2.aWw() && !lVar2.aWv().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(i.e(this.mPageContext, lVar2.aWv()));
                    } else {
                        arrayList.add(lVar2.aWv());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            ImageViewerConfig isShowHost = new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true).setIsShowHost(false);
            isShowHost.getIntent().putExtra("from", "portrait");
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, isShowHost));
        }
    }

    public void ao(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.jZQ)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void cIc() {
        if (this.jZR != null && this.jZR.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.aYm().deletePhoto(this.jZR.getUserData().getPortrait());
        }
    }

    public void cId() {
        com.baidu.adp.lib.f.e.lb().postDelayed(this.jZV, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.jZR != null && this.jZR.getUserData() != null && this.jZR.isHost() && personChangeData.getPhotoChanged()) {
            if (this.jZS == null) {
                this.jZS = new PersonChangeData();
            }
            this.jZS.setPhotoChanged(true);
            cIc();
        }
    }

    public void cIe() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
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

    public void cIf() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.jZQ)));
        }
    }

    public void cIg() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jZV);
    }
}
