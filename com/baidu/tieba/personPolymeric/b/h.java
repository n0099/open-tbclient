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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class h extends d implements View.OnClickListener {
    private CustomMessageListener kGM;
    private boolean kMQ;
    private com.baidu.tieba.personPolymeric.c.a kMR;
    private PersonChangeData kMS;
    private HttpMessageListener kMT;
    private HttpMessageListener kMU;
    private Runnable kMV;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private final WriteImagesInfo writeImagesInfo;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.kMQ = true;
        this.kMT = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    h.this.cTI();
                }
            }
        };
        this.kMU = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        h.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        h.this.cTI();
                    }
                }
            }
        };
        this.kMV = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.kGM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    h.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kGM.setTag(bdUniqueId);
        this.kMU.setTag(bdUniqueId);
        this.kMT.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.kGM);
        this.mPageContext.registerListener(this.kMU);
        this.mPageContext.registerListener(this.kMT);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.kMR = aVar;
    }

    public List<q> cTC() {
        if (this.kMR == null) {
            return null;
        }
        return this.kMR.cTC();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && cTC() != null) {
            q qVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                qVar = ((com.baidu.tieba.person.b.c) view.getTag()).po();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                qVar = ((com.baidu.tieba.person.b.b) view.getTag()).po();
            }
            int position = w.getPosition(cTC(), qVar);
            if (position >= 0) {
                a(qVar, cTC(), position);
            }
        }
    }

    public void a(q qVar, List<q> list, int i, boolean z) {
        if (qVar != null) {
            if (z) {
                if (qVar instanceof m) {
                    c((m) qVar, list, i);
                    return;
                }
                return;
            }
            if (this.kMR != null) {
                this.mIsHost = this.kMR.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (qVar instanceof m) {
                    c((m) qVar, list, i);
                }
            } else if (qVar instanceof com.baidu.tieba.person.data.c) {
                cTG();
            } else if (qVar instanceof m) {
                m mVar = (m) qVar;
                if (mVar.beG()) {
                    a(mVar, list, i);
                } else {
                    b(mVar, list, i);
                }
            }
        }
    }

    public void a(q qVar, List<q> list, int i) {
        a(qVar, list, i, false);
    }

    private void cTG() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    h.this.kMQ = false;
                    switch (i) {
                        case 0:
                            h.this.cTJ();
                            break;
                        case 1:
                            h.this.cTK();
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

    private void a(final m mVar, final List<q> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    h.this.kMQ = true;
                    switch (i2) {
                        case 0:
                            h.this.c(mVar, list, i);
                            break;
                        case 1:
                            if (h.this.mIsHost && h.this.kMR != null && h.this.kMR.getUserData() != null && !h.this.kMR.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.kMR.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.kMR.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cTJ();
                                break;
                            }
                            break;
                        case 2:
                            if (h.this.mIsHost && h.this.kMR != null && h.this.kMR.getUserData() != null && !h.this.kMR.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.kMR.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.kMR.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cTK();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new ao("c11616").ag("obj_type", 1));
                            h.this.cTL();
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

    private void b(final m mVar, final List<q> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        h.this.c(mVar, list, i);
                        break;
                    case 1:
                        i.a(mVar, h.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        i.a(mVar, list);
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
    public void c(m mVar, List<q> list, int i) {
        if (this.mPageContext != null && mVar != null && list != null && !StringUtils.isNull(mVar.beF())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (q qVar : list) {
                if (qVar instanceof m) {
                    m mVar2 = (m) qVar;
                    if (mVar2.beG() && !mVar2.beF().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(i.e(this.mPageContext, mVar2.beF()));
                    } else {
                        arrayList.add(mVar2.beF());
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

    public void Y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!w.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.kMQ)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void cTH() {
        if (this.kMR != null && this.kMR.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.bgz().deletePhoto(this.kMR.getUserData().getPortrait());
        }
    }

    public void cTI() {
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kMV, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.kMR != null && this.kMR.getUserData() != null && this.kMR.isHost() && personChangeData.getPhotoChanged()) {
            if (this.kMS == null) {
                this.kMS = new PersonChangeData();
            }
            this.kMS.setPhotoChanged(true);
            cTH();
        }
    }

    public void cTJ() {
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

    public void cTK() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.kMQ)));
        }
    }

    public void cTL() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kMV);
    }
}
