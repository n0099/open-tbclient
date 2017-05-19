package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    private TbPageContext ajr;
    private PersonPolymericModel eCy;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eCw = true;
    private boolean eCx = false;
    private boolean eCz = false;
    private HttpMessageListener eCA = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eCB = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eCC = new t(this);
    private CustomMessageListener eCD = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ajr = tbPageContext;
        this.eCD.setTag(bdUniqueId);
        this.eCB.setTag(bdUniqueId);
        this.eCA.setTag(bdUniqueId);
        this.ajr.registerListener(this.eCD);
        this.ajr.registerListener(this.eCB);
        this.ajr.registerListener(this.eCA);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.eCy = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aPE() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aPE();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aPE() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                vVar = ((com.baidu.tieba.person.b.b) view.getTag()).wL();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                vVar = ((com.baidu.tieba.person.b.a) view.getTag()).wL();
            }
            int a = com.baidu.tbadk.core.util.x.a(aPE(), vVar);
            if (a >= 0) {
                a(vVar, aPE(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                this.ajr.showToast(w.l.neterror);
            } else if (!this.mPersonPolymericData.Nd()) {
                if (vVar instanceof com.baidu.tbadk.data.j) {
                    b((com.baidu.tbadk.data.j) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aPF();
            } else if (vVar instanceof com.baidu.tbadk.data.j) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) vVar;
                if (jVar.BV()) {
                    a(jVar, list, i);
                } else {
                    c(jVar, list, i);
                }
            }
        }
    }

    private void aPF() {
        if (this.ajr != null) {
            String[] strArr = {this.ajr.getString(w.l.choose_local_photo), this.ajr.getString(w.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
            cVar.ca(w.l.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.ajr);
            cVar.tg();
        }
    }

    private void a(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajr != null) {
            String[] strArr = {this.ajr.getString(w.l.hd_photo), this.ajr.getString(w.l.change_photo), this.ajr.getString(w.l.change_system_photo), this.ajr.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
            cVar.ca(w.l.operation);
            cVar.a(strArr, new w(this, jVar, list, i));
            cVar.d(this.ajr);
            cVar.tg();
        }
    }

    private void b(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajr != null) {
            String[] strArr = {this.ajr.getString(w.l.hd_photo), this.ajr.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
            cVar.ca(w.l.operation);
            cVar.a(strArr, new x(this, jVar, list, i));
            cVar.d(this.ajr);
            cVar.tg();
        }
    }

    private void c(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.ajr.getString(w.l.look_big_photo), this.ajr.getString(w.l.set_as_portrait_photo), this.ajr.getString(w.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajr.getPageActivity());
        cVar.ca(w.l.operation);
        cVar.a(strArr, new y(this, jVar, list, i));
        cVar.d(this.ajr);
        cVar.tg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajr != null && jVar != null && list != null && !StringUtils.isNull(jVar.BU())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.j) {
                    com.baidu.tbadk.data.j jVar2 = (com.baidu.tbadk.data.j) vVar;
                    if (jVar2.BV()) {
                        arrayList.add(aa.g(this.ajr, jVar2.BU()));
                    } else {
                        arrayList.add(jVar2.BU());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ajr.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void Q(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.x.r(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ajr.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eCw)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aPG() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DN().fJ(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eCx = true;
    }

    public void jb(boolean z) {
        this.eCz = z;
    }

    public void aPH() {
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eCC, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.Nd() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aPG();
        }
    }

    public void aPI() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void RQ() {
        if (this.ajr != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.ajr.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aPJ() {
        if (this.ajr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.ajr.getPageActivity(), 12014, this.eCw)));
        }
    }

    public void aPK() {
        if (this.ajr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.ajr.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eCC);
    }
}
