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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes24.dex */
public class i extends e implements View.OnClickListener {
    private CustomMessageListener lWn;
    private HttpMessageListener mChangePortraitListener;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private HttpMessageListener mResetUserPicsListener;
    private PersonChangeData mcA;
    private Runnable mcB;
    private boolean mcy;
    private com.baidu.tieba.personPolymeric.c.a mcz;
    private final WriteImagesInfo writeImagesInfo;

    public i(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(z);
        this.writeImagesInfo = new WriteImagesInfo(1);
        this.mcy = true;
        this.mChangePortraitListener = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.i.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                    i.this.dvy();
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
                        i.this.dvy();
                    }
                }
            }
        };
        this.mcB = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.6
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921424));
            }
        };
        this.lWn = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                    i.this.a((PersonChangeData) customResponsedMessage.getData());
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.lWn.setTag(bdUniqueId);
        this.mResetUserPicsListener.setTag(bdUniqueId);
        this.mChangePortraitListener.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.lWn);
        this.mPageContext.registerListener(this.mResetUserPicsListener);
        this.mPageContext.registerListener(this.mChangePortraitListener);
    }

    public void d(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.mcz = aVar;
    }

    public List<q> dvs() {
        if (this.mcz == null) {
            return null;
        }
        return this.mcz.dvs();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && dvs() != null) {
            q qVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                qVar = ((com.baidu.tieba.person.b.c) view.getTag()).qT();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                qVar = ((com.baidu.tieba.person.b.b) view.getTag()).qT();
            }
            int position = y.getPosition(dvs(), qVar);
            if (position >= 0) {
                a(qVar, dvs(), position);
            }
        }
    }

    public void a(q qVar, List<q> list, int i, boolean z) {
        if (qVar != null) {
            if (z) {
                if (qVar instanceof n) {
                    c((n) qVar, list, i);
                    return;
                }
                return;
            }
            if (this.mcz != null) {
                this.mIsHost = this.mcz.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.mIsHost) {
                if (qVar instanceof n) {
                    c((n) qVar, list, i);
                }
            } else if (qVar instanceof com.baidu.tieba.person.data.c) {
                dvw();
            } else if (qVar instanceof n) {
                n nVar = (n) qVar;
                if (nVar.byY()) {
                    a(nVar, list, i);
                } else {
                    b(nVar, list, i);
                }
            }
        }
    }

    public void a(q qVar, List<q> list, int i) {
        a(qVar, list, i, false);
    }

    private void dvw() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                    i.this.mcy = false;
                    switch (i) {
                        case 0:
                            i.this.dvz();
                            break;
                        case 1:
                            i.this.dvA();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.Qj();
        }
    }

    private void a(final n nVar, final List<q> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(com.baidu.tbadk.core.dialog.k kVar, int i2, View view) {
                    i.this.mcy = true;
                    switch (i2) {
                        case 0:
                            i.this.c(nVar, list, i);
                            break;
                        case 1:
                            if (i.this.mIsHost && i.this.mcz != null && i.this.mcz.getUserData() != null && !i.this.mcz.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(i.this.mcz.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), i.this.mcz.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                i.this.dvz();
                                break;
                            }
                            break;
                        case 2:
                            if (i.this.mIsHost && i.this.mcz != null && i.this.mcz.getUserData() != null && !i.this.mcz.getUserData().canModifyAvatar()) {
                                if (!StringUtils.isNull(i.this.mcz.getUserData().getCantModifyAvatarDesc())) {
                                    l.showLongToast(TbadkCoreApplication.getInst(), i.this.mcz.getUserData().getCantModifyAvatarDesc());
                                    break;
                                } else {
                                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                                    break;
                                }
                            } else {
                                i.this.dvA();
                                break;
                            }
                            break;
                        case 3:
                            TiebaStatic.log(new aq("c11616").al("obj_type", 1));
                            i.this.dvB();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.Qj();
        }
    }

    private void b(final n nVar, final List<q> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.i.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        i.this.c(nVar, list, i);
                        break;
                    case 1:
                        j.a(nVar, i.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        j.a(nVar, list);
                        break;
                }
                if (iVar.isShowing()) {
                    iVar.dismiss();
                }
            }
        });
        iVar.Qj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar, List<q> list, int i) {
        if (this.mPageContext != null && nVar != null && list != null && !StringUtils.isNull(nVar.byX())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (q qVar : list) {
                if (qVar instanceof n) {
                    n nVar2 = (n) qVar;
                    if (nVar2.byY() && !nVar2.byX().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(j.g(this.mPageContext, nVar2.byX()));
                    } else {
                        arrayList.add(nVar2.byX());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).nP(i).ix(true).AH(str).iy(true).iD(false);
            ImageViewerConfig dU = aVar.dU(this.mPageContext.getPageActivity());
            dU.getIntent().putExtra("from", "portrait");
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        }
    }

    public void Y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!y.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.mcy)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void dvx() {
        if (this.mcz != null && this.mcz.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.bBd().deletePhoto(this.mcz.getUserData().getPortrait());
        }
    }

    public void dvy() {
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mcB, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mcz != null && this.mcz.getUserData() != null && this.mcz.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mcA == null) {
                this.mcA = new PersonChangeData();
            }
            this.mcA.setPhotoChanged(true);
            dvx();
        }
    }

    public void dvz() {
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

    public void dvA() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.mcy)));
        }
    }

    public void dvB() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mcB);
    }
}
