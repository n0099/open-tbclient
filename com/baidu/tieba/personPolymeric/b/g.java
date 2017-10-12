package com.baidu.tieba.personPolymeric.b;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.c.a ffQ;
    private PersonPolymericModel ffu;
    protected boolean isHost;
    private TbPageContext mG;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean ffO = true;
    private boolean ffP = false;
    private boolean ffR = false;
    private HttpMessageListener ffS = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.aWP();
            }
        }
    };
    private HttpMessageListener ffT = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mG.showToast(setUserPicsResponse.getErrorString());
                    g.this.kn(false);
                    return;
                }
                g.this.aWP();
            }
        }
    };
    private Runnable ffU = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.7
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.ffu != null && g.this.ffQ != null && g.this.ffQ.isHost()) {
                g.this.ffu.resetData();
                g.this.ffu.cp(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener faP = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                g.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.mG = tbPageContext;
        this.isHost = z;
        this.faP.setTag(bdUniqueId);
        this.ffT.setTag(bdUniqueId);
        this.ffS.setTag(bdUniqueId);
        this.mG.registerListener(this.faP);
        this.mG.registerListener(this.ffT);
        this.mG.registerListener(this.ffS);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ffQ = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.ffu = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aWM() {
        if (this.ffQ == null) {
            return null;
        }
        return this.ffQ.aWM();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aWM() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                fVar = ((com.baidu.tieba.person.b.c) view.getTag()).wT();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).wT();
            }
            int a = v.a(aWM(), fVar);
            if (a >= 0) {
                a(fVar, aWM(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.ffQ != null) {
                this.isHost = this.ffQ.isHost();
            }
            if (!l.hy()) {
                this.mG.showToast(d.l.neterror);
            } else if (!this.isHost) {
                if (fVar instanceof com.baidu.tbadk.data.j) {
                    b((com.baidu.tbadk.data.j) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.c) {
                aWN();
            } else if (fVar instanceof com.baidu.tbadk.data.j) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) fVar;
                if (jVar.Cc()) {
                    a(jVar, list, i);
                } else {
                    c(jVar, list, i);
                }
            }
        }
    }

    private void aWN() {
        if (this.mG != null) {
            String[] strArr = {this.mG.getString(d.l.choose_local_photo), this.mG.getString(d.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
            bVar.cg(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.ffO = false;
                    switch (i) {
                        case 0:
                            g.this.WF();
                            break;
                        case 1:
                            g.this.aWR();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mG);
            bVar.tl();
        }
    }

    private void a(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mG != null) {
            String[] strArr = {this.mG.getString(d.l.hd_photo), this.mG.getString(d.l.change_photo), this.mG.getString(d.l.change_system_photo), this.mG.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
            bVar.cg(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.ffO = true;
                    switch (i2) {
                        case 0:
                            g.this.d(jVar, list, i);
                            break;
                        case 1:
                            g.this.WF();
                            break;
                        case 2:
                            g.this.aWR();
                            break;
                        case 3:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 1));
                            g.this.aWS();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mG);
            bVar.tl();
        }
    }

    private void b(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mG != null) {
            String[] strArr = {this.mG.getString(d.l.hd_photo), this.mG.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
            bVar.cg(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            g.this.d(jVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 2));
                            g.this.aWS();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mG);
            bVar.tl();
        }
    }

    private void c(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.mG.getString(d.l.look_big_photo), this.mG.getString(d.l.set_as_portrait_photo), this.mG.getString(d.l.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
        bVar.cg(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.d(jVar, list, i);
                        break;
                    case 1:
                        h.a(jVar, g.this.mG.getUniqueId());
                        break;
                    case 2:
                        h.a(jVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mG);
        bVar.tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.mG != null && jVar != null && list != null && !StringUtils.isNull(jVar.Cb())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.j) {
                    com.baidu.tbadk.data.j jVar2 = (com.baidu.tbadk.data.j) fVar;
                    if (jVar2.Cc()) {
                        arrayList.add(h.g(this.mG, jVar2.Cb()));
                    } else {
                        arrayList.add(jVar2.Cb());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mG.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mG.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void P(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.u(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mG.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.ffO)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aWO() {
        if (this.ffQ != null && this.ffQ.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DZ().gf(this.ffQ.getUserData().getPortrait());
        }
        this.ffP = true;
    }

    public void kn(boolean z) {
        this.ffR = z;
    }

    public void aWP() {
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ffU, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.ffQ != null && this.ffQ.getUserData() != null && this.ffQ.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aWO();
        }
    }

    public void aWQ() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.o(str2, g.this.aWM());
                    g.this.kn(true);
                }
            }
        });
    }

    public void WF() {
        if (this.mG != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mG.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aWR() {
        if (this.mG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mG.getPageActivity(), 12014, this.ffO)));
        }
    }

    public void aWS() {
        if (this.mG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mG.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ffU);
    }
}
