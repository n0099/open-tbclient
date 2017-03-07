package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
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
    private TbPageContext ajF;
    private PersonPolymericModel eGX;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eGV = true;
    private boolean eGW = false;
    private boolean eGY = false;
    private HttpMessageListener eGZ = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eHa = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eHb = new t(this);
    private CustomMessageListener eHc = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.ajF = tbPageContext;
        this.ajF.registerListener(this.eHc);
        this.ajF.registerListener(this.eHa);
        this.ajF.registerListener(this.eGZ);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.eGX = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aRh() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aRh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aRh() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.holder.d) {
                vVar = ((com.baidu.tieba.person.holder.d) view.getTag()).xb();
            } else if (view.getTag() instanceof com.baidu.tieba.person.holder.c) {
                vVar = ((com.baidu.tieba.person.holder.c) view.getTag()).xb();
            }
            int a = com.baidu.tbadk.core.util.x.a(aRh(), vVar);
            if (a >= 0) {
                a(vVar, aRh(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.hv()) {
                this.ajF.showToast(w.l.neterror);
            } else if (!this.mPersonPolymericData.Nj()) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aRi();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.Cs()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aRi() {
        if (this.ajF != null) {
            String[] strArr = {this.ajF.getString(w.l.choose_local_photo), this.ajF.getString(w.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajF.getPageActivity());
            cVar.bZ(w.l.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.ajF);
            cVar.tv();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajF != null) {
            String[] strArr = {this.ajF.getString(w.l.hd_photo), this.ajF.getString(w.l.change_photo), this.ajF.getString(w.l.change_system_photo), this.ajF.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajF.getPageActivity());
            cVar.bZ(w.l.operation);
            cVar.a(strArr, new w(this, kVar, list, i));
            cVar.d(this.ajF);
            cVar.tv();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajF != null) {
            String[] strArr = {this.ajF.getString(w.l.hd_photo), this.ajF.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajF.getPageActivity());
            cVar.bZ(w.l.operation);
            cVar.a(strArr, new x(this, kVar, list, i));
            cVar.d(this.ajF);
            cVar.tv();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.ajF.getString(w.l.look_big_photo), this.ajF.getString(w.l.set_as_portrait_photo), this.ajF.getString(w.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajF.getPageActivity());
        cVar.bZ(w.l.operation);
        cVar.a(strArr, new y(this, kVar, list, i));
        cVar.d(this.ajF);
        cVar.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajF != null && kVar != null && list != null && !StringUtils.isNull(kVar.Cr())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.Cs()) {
                        arrayList.add(aa.h(this.ajF, kVar2.Cr()));
                    } else {
                        arrayList.add(kVar2.Cr());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.ajF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ajF.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void N(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.x.q(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ajF.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eGV)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aRj() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.El().fG(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eGW = true;
    }

    public void jm(boolean z) {
        this.eGY = z;
    }

    public void aRk() {
        com.baidu.adp.lib.g.h.fM().postDelayed(this.eHb, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.Nj() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aRj();
        }
    }

    public void aRl() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void QV() {
        if (this.ajF != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.ajF.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aRm() {
        if (this.ajF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.ajF.getPageActivity(), 12014, this.eGV)));
        }
    }

    public void aRn() {
        if (this.ajF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.ajF.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eHb);
    }
}
