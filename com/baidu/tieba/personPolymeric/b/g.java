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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.c.a hQO;
    private PersonPolymericModel hQs;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean hQN = true;
    private HttpMessageListener hQP = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bRZ();
            }
        }
    };
    private HttpMessageListener hQQ = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.oL(false);
                    return;
                }
                g.this.bRZ();
            }
        }
    };
    private Runnable hQR = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.6
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hQs != null && g.this.hQO != null && g.this.hQO.isHost()) {
                g.this.hQs.resetData();
                g.this.hQs.dG(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener hLX = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                g.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.mPageContext = tbPageContext;
        this.isHost = z;
        this.hLX.setTag(bdUniqueId);
        this.hQQ.setTag(bdUniqueId);
        this.hQP.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.hLX);
        this.mPageContext.registerListener(this.hQQ);
        this.mPageContext.registerListener(this.hQP);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.hQO = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.hQs = personPolymericModel;
    }

    public List<m> bRW() {
        if (this.hQO == null) {
            return null;
        }
        return this.hQO.bRW();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && bRW() != null) {
            m mVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                mVar = ((com.baidu.tieba.person.b.c) view.getTag()).afg();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                mVar = ((com.baidu.tieba.person.b.b) view.getTag()).afg();
            }
            int a = v.a(bRW(), mVar);
            if (a >= 0) {
                a(mVar, bRW(), a);
            }
        }
    }

    public void a(m mVar, List<m> list, int i) {
        if (mVar != null) {
            if (this.hQO != null) {
                this.isHost = this.hQO.isHost();
            }
            if (!l.lo()) {
                this.mPageContext.showToast(d.j.neterror);
            } else if (!this.isHost) {
                if (mVar instanceof com.baidu.tbadk.data.m) {
                    c((com.baidu.tbadk.data.m) mVar, list, i);
                }
            } else if (mVar instanceof com.baidu.tieba.person.data.c) {
                bRX();
            } else if (mVar instanceof com.baidu.tbadk.data.m) {
                com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
                if (mVar2.isPortrait()) {
                    a(mVar2, list, i);
                } else {
                    b(mVar2, list, i);
                }
            }
        }
    }

    private void bRX() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.choose_local_photo), this.mPageContext.getString(d.j.change_system_photo)};
            final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(this.mPageContext);
            gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(com.baidu.tbadk.core.dialog.i iVar, int i, View view) {
                    g.this.hQN = false;
                    switch (i) {
                        case 0:
                            g.this.aPX();
                            break;
                        case 1:
                            g.this.bSb();
                            break;
                    }
                    if (gVar.isShowing()) {
                        gVar.dismiss();
                    }
                }
            });
            gVar.showDialog();
        }
    }

    private void a(final com.baidu.tbadk.data.m mVar, final List<m> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.hd_photo), this.mPageContext.getString(d.j.change_photo), this.mPageContext.getString(d.j.change_system_photo), this.mPageContext.getString(d.j.check_headpendant)};
            final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(this.mPageContext);
            gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(com.baidu.tbadk.core.dialog.i iVar, int i2, View view) {
                    g.this.hQN = true;
                    switch (i2) {
                        case 0:
                            g.this.c(mVar, list, i);
                            break;
                        case 1:
                            g.this.aPX();
                            break;
                        case 2:
                            g.this.bSb();
                            break;
                        case 3:
                            TiebaStatic.log(new am("c11616").T("obj_type", 1));
                            g.this.bSc();
                            break;
                    }
                    if (gVar.isShowing()) {
                        gVar.dismiss();
                    }
                }
            });
            gVar.showDialog();
        }
    }

    private void b(final com.baidu.tbadk.data.m mVar, final List<m> list, final int i) {
        String[] strArr = {this.mPageContext.getString(d.j.look_big_photo), this.mPageContext.getString(d.j.set_as_portrait_photo), this.mPageContext.getString(d.j.delete)};
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(this.mPageContext);
        gVar.a(null, strArr, new i.c() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(com.baidu.tbadk.core.dialog.i iVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.c(mVar, list, i);
                        break;
                    case 1:
                        h.a(mVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(mVar, list);
                        break;
                }
                if (gVar.isShowing()) {
                    gVar.dismiss();
                }
            }
        });
        gVar.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.data.m mVar, List<m> list, int i) {
        if (this.mPageContext != null && mVar != null && list != null && !StringUtils.isNull(mVar.alv())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (m mVar2 : list) {
                if (mVar2 instanceof com.baidu.tbadk.data.m) {
                    com.baidu.tbadk.data.m mVar3 = (com.baidu.tbadk.data.m) mVar2;
                    if (mVar3.isPortrait() && !mVar3.alv().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, mVar3.alv()));
                    } else {
                        arrayList.add(mVar3.alv());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mPageContext.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true).setIsShowHost(false)));
        }
    }

    public void aj(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.T(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.hQN)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bRY() {
        if (this.hQO != null && this.hQO.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.anm().pg(this.hQO.getUserData().getPortrait());
        }
    }

    public void oL(boolean z) {
    }

    public void bRZ() {
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hQR, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.hQO != null && this.hQO.getUserData() != null && this.hQO.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bRY();
        }
    }

    public void bSa() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.8
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.r(str2, g.this.bRW());
                    g.this.oL(true);
                }
            }
        });
    }

    public void aPX() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adN();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.Y(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bSb() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.hQN)));
        }
    }

    public void bSc() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hQR);
    }
}
