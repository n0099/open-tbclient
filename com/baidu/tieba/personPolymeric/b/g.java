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
    private PersonPolymericModel fnT;
    private com.baidu.tieba.personPolymeric.c.a fop;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean foo = true;
    private HttpMessageListener foq = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.aZV();
            }
        }
    };

    /* renamed from: for  reason: not valid java name */
    private HttpMessageListener f0for = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.km(false);
                    return;
                }
                g.this.aZV();
            }
        }
    };
    private Runnable fot = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.7
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fnT != null && g.this.fop != null && g.this.fop.isHost()) {
                g.this.fnT.resetData();
                g.this.fnT.cr(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener fjp = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.g.8
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
        this.fjp.setTag(bdUniqueId);
        this.f0for.setTag(bdUniqueId);
        this.foq.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.fjp);
        this.mPageContext.registerListener(this.f0for);
        this.mPageContext.registerListener(this.foq);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fop = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.fnT = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aZS() {
        if (this.fop == null) {
            return null;
        }
        return this.fop.aZS();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aZS() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                fVar = ((com.baidu.tieba.person.b.c) view.getTag()).wT();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).wT();
            }
            int a = v.a(aZS(), fVar);
            if (a >= 0) {
                a(fVar, aZS(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.fop != null) {
                this.isHost = this.fop.isHost();
            }
            if (!l.hy()) {
                this.mPageContext.showToast(d.j.neterror);
            } else if (!this.isHost) {
                if (fVar instanceof com.baidu.tbadk.data.l) {
                    b((com.baidu.tbadk.data.l) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.c) {
                aZT();
            } else if (fVar instanceof com.baidu.tbadk.data.l) {
                com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) fVar;
                if (lVar.Cx()) {
                    a(lVar, list, i);
                } else {
                    c(lVar, list, i);
                }
            }
        }
    }

    private void aZT() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.choose_local_photo), this.mPageContext.getString(d.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.foo = false;
                    switch (i) {
                        case 0:
                            g.this.YV();
                            break;
                        case 1:
                            g.this.aZX();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tl();
        }
    }

    private void a(final com.baidu.tbadk.data.l lVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.hd_photo), this.mPageContext.getString(d.j.change_photo), this.mPageContext.getString(d.j.change_system_photo), this.mPageContext.getString(d.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.foo = true;
                    switch (i2) {
                        case 0:
                            g.this.d(lVar, list, i);
                            break;
                        case 1:
                            g.this.YV();
                            break;
                        case 2:
                            g.this.aZX();
                            break;
                        case 3:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 1));
                            g.this.aZY();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tl();
        }
    }

    private void b(final com.baidu.tbadk.data.l lVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.hd_photo), this.mPageContext.getString(d.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            g.this.d(lVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 2));
                            g.this.aZY();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tl();
        }
    }

    private void c(final com.baidu.tbadk.data.l lVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.mPageContext.getString(d.j.look_big_photo), this.mPageContext.getString(d.j.set_as_portrait_photo), this.mPageContext.getString(d.j.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.cf(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.d(lVar, list, i);
                        break;
                    case 1:
                        h.a(lVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(lVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mPageContext);
        bVar.tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.mPageContext != null && lVar != null && list != null && !StringUtils.isNull(lVar.Cw())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.l) {
                    com.baidu.tbadk.data.l lVar2 = (com.baidu.tbadk.data.l) fVar;
                    if (lVar2.Cx()) {
                        arrayList.add(h.g(this.mPageContext, lVar2.Cw()));
                    } else {
                        arrayList.add(lVar2.Cw());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void O(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.v(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.foo)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aZU() {
        if (this.fop != null && this.fop.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Es().gm(this.fop.getUserData().getPortrait());
        }
    }

    public void km(boolean z) {
    }

    public void aZV() {
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fot, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fop != null && this.fop.getUserData() != null && this.fop.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aZU();
        }
    }

    public void aZW() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.p(str2, g.this.aZS());
                    g.this.km(true);
                }
            }
        });
    }

    public void YV() {
        if (this.mPageContext != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aZX() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), 12014, this.foo)));
        }
    }

    public void aZY() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fot);
    }
}
