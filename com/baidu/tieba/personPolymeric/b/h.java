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
import com.baidu.adp.widget.ListView.o;
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
    private CustomMessageListener klP;
    private boolean krN;
    private com.baidu.tieba.personPolymeric.c.a krO;
    private PersonChangeData krP;
    private HttpMessageListener krQ;
    private HttpMessageListener krR;
    private Runnable krS;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private final WriteImagesInfo writeImagesInfo;

    public h(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.krN = true;
        this.krQ = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    h.this.cPa();
                }
            }
        };
        this.krR = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        h.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        h.this.cPa();
                    }
                }
            }
        };
        this.krS = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.h.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.klP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.h.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    h.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.klP.setTag(bdUniqueId);
        this.krR.setTag(bdUniqueId);
        this.krQ.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.klP);
        this.mPageContext.registerListener(this.krR);
        this.mPageContext.registerListener(this.krQ);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.krO = aVar;
    }

    public List<o> cOU() {
        if (this.krO == null) {
            return null;
        }
        return this.krO.cOU();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && cOU() != null) {
            o oVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                oVar = ((com.baidu.tieba.person.b.c) view.getTag()).oX();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                oVar = ((com.baidu.tieba.person.b.b) view.getTag()).oX();
            }
            int position = v.getPosition(cOU(), oVar);
            if (position >= 0) {
                a(oVar, cOU(), position);
            }
        }
    }

    public void a(o oVar, List<o> list, int i, boolean z) {
        if (oVar != null) {
            if (z) {
                if (oVar instanceof m) {
                    c((m) oVar, list, i);
                    return;
                }
                return;
            }
            if (this.krO != null) {
                this.mIsHost = this.krO.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (oVar instanceof m) {
                    c((m) oVar, list, i);
                }
            } else if (oVar instanceof com.baidu.tieba.person.data.c) {
                cOY();
            } else if (oVar instanceof m) {
                m mVar = (m) oVar;
                if (mVar.bcD()) {
                    a(mVar, list, i);
                } else {
                    b(mVar, list, i);
                }
            }
        }
    }

    public void a(o oVar, List<o> list, int i) {
        a(oVar, list, i, false);
    }

    private void cOY() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    h.this.krN = false;
                    switch (i) {
                        case 0:
                            h.this.cPb();
                            break;
                        case 1:
                            h.this.cPc();
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

    private void a(final m mVar, final List<o> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.h.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    h.this.krN = true;
                    switch (i2) {
                        case 0:
                            h.this.c(mVar, list, i);
                            break;
                        case 1:
                            if (h.this.mIsHost && h.this.krO != null && h.this.krO.getUserData() != null && !h.this.krO.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.krO.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.krO.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cPb();
                                break;
                            }
                            break;
                        case 2:
                            if (h.this.mIsHost && h.this.krO != null && h.this.krO.getUserData() != null && !h.this.krO.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(h.this.krO.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), h.this.krO.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                h.this.cPc();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").ag("obj_type", 1));
                            h.this.cPd();
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

    private void b(final m mVar, final List<o> list, final int i) {
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
    public void c(m mVar, List<o> list, int i) {
        if (this.mPageContext != null && mVar != null && list != null && !StringUtils.isNull(mVar.bcC())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (o oVar : list) {
                if (oVar instanceof m) {
                    m mVar2 = (m) oVar;
                    if (mVar2.bcD() && !mVar2.bcC().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(i.e(this.mPageContext, mVar2.bcC()));
                    } else {
                        arrayList.add(mVar2.bcC());
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
            if (!v.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.krN)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void cOZ() {
        if (this.krO != null && this.krO.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.bet().deletePhoto(this.krO.getUserData().getPortrait());
        }
    }

    public void cPa() {
        com.baidu.adp.lib.f.e.ld().postDelayed(this.krS, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.krO != null && this.krO.getUserData() != null && this.krO.isHost() && personChangeData.getPhotoChanged()) {
            if (this.krP == null) {
                this.krP = new PersonChangeData();
            }
            this.krP.setPhotoChanged(true);
            cOZ();
        }
    }

    public void cPb() {
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

    public void cPc() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.krN)));
        }
    }

    public void cPd() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.krS);
    }
}
