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
public class z implements View.OnClickListener {
    private TbPageContext ajP;
    protected boolean boT;
    private PersonPolymericModel bzq;
    private com.baidu.tieba.personPolymeric.c.a eVv;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eVt = true;
    private boolean eVu = false;
    private boolean eVw = false;
    private HttpMessageListener eVx = new aa(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eVy = new ab(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eVz = new ac(this);
    private CustomMessageListener eVA = new ad(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public z(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.ajP = tbPageContext;
        this.boT = z;
        this.eVA.setTag(bdUniqueId);
        this.eVy.setTag(bdUniqueId);
        this.eVx.setTag(bdUniqueId);
        this.ajP.registerListener(this.eVA);
        this.ajP.registerListener(this.eVy);
        this.ajP.registerListener(this.eVx);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.eVv = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.bzq = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aVl() {
        if (this.eVv == null) {
            return null;
        }
        return this.eVv.aVl();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aVl() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                vVar = ((com.baidu.tieba.person.b.b) view.getTag()).wZ();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                vVar = ((com.baidu.tieba.person.b.a) view.getTag()).wZ();
            }
            int a = com.baidu.tbadk.core.util.z.a(aVl(), vVar);
            if (a >= 0) {
                a(vVar, aVl(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null) {
            if (this.eVv != null) {
                this.boT = this.eVv.Oy();
            }
            if (!com.baidu.adp.lib.util.k.hA()) {
                this.ajP.showToast(w.l.neterror);
            } else if (!this.boT) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aVm();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.Cj()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aVm() {
        if (this.ajP != null) {
            String[] strArr = {this.ajP.getString(w.l.choose_local_photo), this.ajP.getString(w.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new ae(this));
            cVar.d(this.ajP);
            cVar.td();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajP != null) {
            String[] strArr = {this.ajP.getString(w.l.hd_photo), this.ajP.getString(w.l.change_photo), this.ajP.getString(w.l.change_system_photo), this.ajP.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new af(this, kVar, list, i));
            cVar.d(this.ajP);
            cVar.td();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajP != null) {
            String[] strArr = {this.ajP.getString(w.l.hd_photo), this.ajP.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new ag(this, kVar, list, i));
            cVar.d(this.ajP);
            cVar.td();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.ajP.getString(w.l.look_big_photo), this.ajP.getString(w.l.set_as_portrait_photo), this.ajP.getString(w.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajP.getPageActivity());
        cVar.cb(w.l.operation);
        cVar.a(strArr, new ah(this, kVar, list, i));
        cVar.d(this.ajP);
        cVar.td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajP != null && kVar != null && list != null && !StringUtils.isNull(kVar.Ci())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.Cj()) {
                        arrayList.add(aj.g(this.ajP, kVar2.Ci()));
                    } else {
                        arrayList.add(kVar2.Ci());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.ajP.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ajP.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void Q(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.z.t(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ajP.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eVt)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aVn() {
        if (this.eVv != null && this.eVv.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Eb().gb(this.eVv.getUserData().getPortrait());
        }
        this.eVu = true;
    }

    public void jV(boolean z) {
        this.eVw = z;
    }

    public void aVo() {
        com.baidu.adp.lib.g.h.fR().postDelayed(this.eVz, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.eVv != null && this.eVv.getUserData() != null && this.eVv.Oy() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aVn();
        }
    }

    public void aVp() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ai(this));
    }

    public void TR() {
        if (this.ajP != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.ajP.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aVq() {
        if (this.ajP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.ajP.getPageActivity(), 12014, this.eVt)));
        }
    }

    public void aVr() {
        if (this.ajP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.ajP.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eVz);
    }
}
