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
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.o;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.holder.PersonInfoAddUserPicViewHolder;
import com.baidu.tieba.person.holder.PersonInfoUserPicViewHolder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class i extends e implements View.OnClickListener {
    private boolean mAV;
    private com.baidu.tieba.personPolymeric.c.a mAW;
    private PersonChangeData mAX;
    private Runnable mAY;
    private HttpMessageListener mChangePortraitListener;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private HttpMessageListener mResetUserPicsListener;
    private CustomMessageListener muI;
    private final WriteImagesInfo writeImagesInfo;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.mAV = true;
        this.mChangePortraitListener = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.i.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    i.this.dyF();
                }
            }
        };
        this.mResetUserPicsListener = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.i.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                    SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                    if (setUserPicsResponse.getErrCode() != 0) {
                        i.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    } else {
                        i.this.dyF();
                    }
                }
            }
        };
        this.mAY = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.muI = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    i.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.muI.setTag(bdUniqueId);
        this.mResetUserPicsListener.setTag(bdUniqueId);
        this.mChangePortraitListener.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.muI);
        this.mPageContext.registerListener(this.mResetUserPicsListener);
        this.mPageContext.registerListener(this.mChangePortraitListener);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.mAW = aVar;
    }

    public List<n> dyz() {
        if (this.mAW == null) {
            return null;
        }
        return this.mAW.dyz();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && dyz() != null) {
            n nVar = null;
            if (view.getTag() instanceof PersonInfoUserPicViewHolder) {
                nVar = ((PersonInfoUserPicViewHolder) view.getTag()).qv();
            } else if (view.getTag() instanceof PersonInfoAddUserPicViewHolder) {
                nVar = ((PersonInfoAddUserPicViewHolder) view.getTag()).qv();
            }
            int position = y.getPosition(dyz(), nVar);
            if (position >= 0) {
                a(nVar, dyz(), position);
            }
        }
    }

    public void a(n nVar, List<n> list, int i, boolean z) {
        if (nVar != null) {
            if (z) {
                if (nVar instanceof o) {
                    c((o) nVar, list, i);
                    return;
                }
                return;
            }
            if (this.mAW != null) {
                this.mIsHost = this.mAW.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (nVar instanceof o) {
                    c((o) nVar, list, i);
                }
            } else if (nVar instanceof com.baidu.tieba.person.data.c) {
                dyD();
            } else if (nVar instanceof o) {
                o oVar = (o) nVar;
                if (oVar.bAI()) {
                    a(oVar, list, i);
                } else {
                    b(oVar, list, i);
                }
            }
        }
    }

    public void a(n nVar, List<n> list, int i) {
        a(nVar, list, i, false);
    }

    private void dyD() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    i.this.mAV = false;
                    switch (i) {
                        case 0:
                            i.this.dyG();
                            break;
                        case 1:
                            i.this.dyH();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.QE();
        }
    }

    private void a(final o oVar, final List<n> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i2, View view) {
                    i.this.mAV = true;
                    switch (i2) {
                        case 0:
                            i.this.c(oVar, list, i);
                            break;
                        case 1:
                            if (i.this.mIsHost && i.this.mAW != null && i.this.mAW.getUserData() != null && !i.this.mAW.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(i.this.mAW.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), i.this.mAW.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                i.this.dyG();
                                break;
                            }
                            break;
                        case 2:
                            if (i.this.mIsHost && i.this.mAW != null && i.this.mAW.getUserData() != null && !i.this.mAW.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(i.this.mAW.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), i.this.mAW.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                i.this.dyH();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new ar("c11616").ap("obj_type", 1));
                            i.this.dyI();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.QE();
        }
    }

    private void b(final o oVar, final List<n> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        i.this.c(oVar, list, i);
                        break;
                    case 1:
                        j.a(oVar, i.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        j.a(oVar, list);
                        break;
                }
                if (iVar.isShowing()) {
                    iVar.dismiss();
                }
            }
        });
        iVar.QE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(o oVar, List<n> list, int i) {
        if (this.mPageContext != null && oVar != null && list != null && !StringUtils.isNull(oVar.bAH())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (n nVar : list) {
                if (nVar instanceof o) {
                    o oVar2 = (o) nVar;
                    if (oVar2.bAI() && !oVar2.bAH().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(j.i(this.mPageContext, oVar2.bAH()));
                    } else {
                        arrayList.add(oVar2.bAH());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mQ(i).jg(true).zM(str).jh(true).jm(false);
            ImageViewerConfig eP = aVar.eP(this.mPageContext.getPageActivity());
            eP.getIntent().putExtra("from", "portrait");
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
        }
    }

    public void af(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!y.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.mAV)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void dyE() {
        if (this.mAW != null && this.mAW.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.bCP().deletePhoto(this.mAW.getUserData().getPortrait());
        }
    }

    public void dyF() {
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mAY, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mAW != null && this.mAW.getUserData() != null && this.mAW.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mAX == null) {
                this.mAX = new PersonChangeData();
            }
            this.mAX.setPhotoChanged(true);
            dyE();
        }
    }

    public void dyG() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(12002);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    }

    public void dyH() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.mAV)));
        }
    }

    public void dyI() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mAY);
    }
}
