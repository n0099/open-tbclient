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
    private TbPageContext ajU;
    private PersonPolymericModel eHj;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eHh = true;
    private boolean eHi = false;
    private boolean eHk = false;
    private HttpMessageListener eHl = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eHm = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eHn = new t(this);
    private CustomMessageListener eHo = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.ajU = tbPageContext;
        this.ajU.registerListener(this.eHo);
        this.ajU.registerListener(this.eHm);
        this.ajU.registerListener(this.eHl);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.eHj = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aSr() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aSr();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aSr() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                vVar = ((com.baidu.tieba.person.b.c) view.getTag()).xx();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                vVar = ((com.baidu.tieba.person.b.b) view.getTag()).xx();
            }
            int a = com.baidu.tbadk.core.util.x.a(aSr(), vVar);
            if (a >= 0) {
                a(vVar, aSr(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                this.ajU.showToast(w.l.neterror);
            } else if (!this.mPersonPolymericData.NP()) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aSs();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.CQ()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aSs() {
        if (this.ajU != null) {
            String[] strArr = {this.ajU.getString(w.l.choose_local_photo), this.ajU.getString(w.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajU.getPageActivity());
            cVar.cc(w.l.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.ajU);
            cVar.tT();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajU != null) {
            String[] strArr = {this.ajU.getString(w.l.hd_photo), this.ajU.getString(w.l.change_photo), this.ajU.getString(w.l.change_system_photo), this.ajU.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajU.getPageActivity());
            cVar.cc(w.l.operation);
            cVar.a(strArr, new w(this, kVar, list, i));
            cVar.d(this.ajU);
            cVar.tT();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajU != null) {
            String[] strArr = {this.ajU.getString(w.l.hd_photo), this.ajU.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajU.getPageActivity());
            cVar.cc(w.l.operation);
            cVar.a(strArr, new x(this, kVar, list, i));
            cVar.d(this.ajU);
            cVar.tT();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.ajU.getString(w.l.look_big_photo), this.ajU.getString(w.l.set_as_portrait_photo), this.ajU.getString(w.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajU.getPageActivity());
        cVar.cc(w.l.operation);
        cVar.a(strArr, new y(this, kVar, list, i));
        cVar.d(this.ajU);
        cVar.tT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajU != null && kVar != null && list != null && !StringUtils.isNull(kVar.CP())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.CQ()) {
                        arrayList.add(aa.h(this.ajU, kVar2.CP()));
                    } else {
                        arrayList.add(kVar2.CP());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.ajU.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ajU.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void O(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.x.q(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ajU.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eHh)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aSt() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.EJ().fM(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eHi = true;
    }

    public void jv(boolean z) {
        this.eHk = z;
    }

    public void aSu() {
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eHn, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.NP() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aSt();
        }
    }

    public void aSv() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void Sv() {
        if (this.ajU != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.ajU.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aSw() {
        if (this.ajU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.ajU.getPageActivity(), 12014, this.eHh)));
        }
    }

    public void aSx() {
        if (this.ajU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.ajU.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eHn);
    }
}
