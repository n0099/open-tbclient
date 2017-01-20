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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    private TbPageContext FY;
    private PersonPolymericModel eDv;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eDt = true;
    private boolean eDu = false;
    private boolean eDw = false;
    private HttpMessageListener eDx = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eDy = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eDz = new t(this);
    private CustomMessageListener eDA = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.FY = tbPageContext;
        this.FY.registerListener(this.eDA);
        this.FY.registerListener(this.eDy);
        this.FY.registerListener(this.eDx);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.eDv = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aRE() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aRE();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aRE() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.holder.d) {
                vVar = ((com.baidu.tieba.person.holder.d) view.getTag()).wE();
            } else if (view.getTag() instanceof com.baidu.tieba.person.holder.c) {
                vVar = ((com.baidu.tieba.person.holder.c) view.getTag()).wE();
            }
            int a = com.baidu.tbadk.core.util.w.a(aRE(), vVar);
            if (a >= 0) {
                a(vVar, aRE(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.gB()) {
                this.FY.showToast(r.l.neterror);
            } else if (!this.mPersonPolymericData.Mw()) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aRF();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.BZ()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aRF() {
        if (this.FY != null) {
            String[] strArr = {this.FY.getString(r.l.choose_local_photo), this.FY.getString(r.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.FY.getPageActivity());
            cVar.cd(r.l.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.FY);
            cVar.sY();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.FY != null) {
            String[] strArr = {this.FY.getString(r.l.hd_photo), this.FY.getString(r.l.change_photo), this.FY.getString(r.l.change_system_photo), this.FY.getString(r.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.FY.getPageActivity());
            cVar.cd(r.l.operation);
            cVar.a(strArr, new w(this, kVar, list, i));
            cVar.d(this.FY);
            cVar.sY();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.FY != null) {
            String[] strArr = {this.FY.getString(r.l.hd_photo), this.FY.getString(r.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.FY.getPageActivity());
            cVar.cd(r.l.operation);
            cVar.a(strArr, new x(this, kVar, list, i));
            cVar.d(this.FY);
            cVar.sY();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.FY.getString(r.l.look_big_photo), this.FY.getString(r.l.set_as_portrait_photo), this.FY.getString(r.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.FY.getPageActivity());
        cVar.cd(r.l.operation);
        cVar.a(strArr, new y(this, kVar, list, i));
        cVar.d(this.FY);
        cVar.sY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.FY != null && kVar != null && list != null && !StringUtils.isNull(kVar.BY())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.BZ()) {
                        arrayList.add(aa.i(this.FY, kVar2.BY()));
                    } else {
                        arrayList.add(kVar2.BY());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.FY.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void r(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.w.s(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.FY.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eDt)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aRG() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DS().fR(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eDu = true;
    }

    public void jp(boolean z) {
        this.eDw = z;
    }

    public void aRH() {
        com.baidu.adp.lib.g.h.eE().postDelayed(this.eDz, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.Mw() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aRG();
        }
    }

    public void aRI() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void Qc() {
        if (this.FY != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.FY.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aRJ() {
        if (this.FY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.FY.getPageActivity(), 12014, this.eDt)));
        }
    }

    public void aRK() {
        if (this.FY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.FY.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eDz);
    }
}
