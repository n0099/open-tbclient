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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    private TbPageContext GM;
    private com.baidu.tieba.personPolymeric.mode.c eJD;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eJB = true;
    private boolean eJC = false;
    private boolean eJE = false;
    private HttpMessageListener eJF = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eJG = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eJH = new t(this);
    private CustomMessageListener eJI = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.GM = tbPageContext;
        this.GM.registerListener(this.eJI);
        this.GM.registerListener(this.eJG);
        this.GM.registerListener(this.eJF);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(com.baidu.tieba.personPolymeric.mode.c cVar) {
        this.eJD = cVar;
    }

    public List<com.baidu.adp.widget.ListView.v> aTO() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aTO();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aTO() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.holder.d) {
                vVar = ((com.baidu.tieba.person.holder.d) view.getTag()).wV();
            } else if (view.getTag() instanceof com.baidu.tieba.person.holder.c) {
                vVar = ((com.baidu.tieba.person.holder.c) view.getTag()).wV();
            }
            int a = com.baidu.tbadk.core.util.y.a(aTO(), vVar);
            if (a >= 0) {
                a(vVar, aTO(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                this.GM.showToast(r.j.neterror);
            } else if (!this.mPersonPolymericData.aQi()) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aTP();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.Ci()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aTP() {
        if (this.GM != null) {
            String[] strArr = {this.GM.getString(r.j.choose_local_photo), this.GM.getString(r.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GM.getPageActivity());
            cVar.cc(r.j.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.GM);
            cVar.tp();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GM != null) {
            String[] strArr = {this.GM.getString(r.j.hd_photo), this.GM.getString(r.j.change_photo), this.GM.getString(r.j.change_system_photo), this.GM.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GM.getPageActivity());
            cVar.cc(r.j.operation);
            cVar.a(strArr, new w(this, kVar, list, i));
            cVar.d(this.GM);
            cVar.tp();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GM != null) {
            String[] strArr = {this.GM.getString(r.j.hd_photo), this.GM.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GM.getPageActivity());
            cVar.cc(r.j.operation);
            cVar.a(strArr, new x(this, kVar, list, i));
            cVar.d(this.GM);
            cVar.tp();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.GM.getString(r.j.look_big_photo), this.GM.getString(r.j.set_as_portrait_photo), this.GM.getString(r.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GM.getPageActivity());
        cVar.cc(r.j.operation);
        cVar.a(strArr, new y(this, kVar, list, i));
        cVar.d(this.GM);
        cVar.tp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GM != null && kVar != null && list != null && !StringUtils.isNull(kVar.Ch())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.Ci()) {
                        arrayList.add(aa.i(this.GM, kVar2.Ch()));
                    } else {
                        arrayList.add(kVar2.Ch());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.GM.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.GM.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void r(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.y.t(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.GM.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eJB)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aTQ() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ek().fV(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eJC = true;
    }

    public void iS(boolean z) {
        this.eJE = z;
    }

    public void aTR() {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eJH, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.aQi() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aTQ();
        }
    }

    public void aTS() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void aTT() {
        if (this.GM != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.GM.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aTU() {
        if (this.GM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.GM.getPageActivity(), 12014, this.eJB)));
        }
    }

    public void aTV() {
        if (this.GM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.GM.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJH);
    }
}
