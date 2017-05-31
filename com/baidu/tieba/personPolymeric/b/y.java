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
public class y implements View.OnClickListener {
    private TbPageContext ajh;
    private PersonPolymericModel bwC;
    private com.baidu.tieba.personPolymeric.c.a eLr;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eLp = true;
    private boolean eLq = false;
    private boolean eLs = false;
    private HttpMessageListener eLt = new z(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eLu = new aa(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eLv = new ab(this);
    private CustomMessageListener eLw = new ac(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public y(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ajh = tbPageContext;
        this.eLw.setTag(bdUniqueId);
        this.eLu.setTag(bdUniqueId);
        this.eLt.setTag(bdUniqueId);
        this.ajh.registerListener(this.eLw);
        this.ajh.registerListener(this.eLu);
        this.ajh.registerListener(this.eLt);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.eLr = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.bwC = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.v> aRe() {
        if (this.eLr == null) {
            return null;
        }
        return this.eLr.aRe();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aRe() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                vVar = ((com.baidu.tieba.person.b.b) view.getTag()).wH();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                vVar = ((com.baidu.tieba.person.b.a) view.getTag()).wH();
            }
            int a = com.baidu.tbadk.core.util.x.a(aRe(), vVar);
            if (a >= 0) {
                a(vVar, aRe(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.eLr != null) {
            if (!com.baidu.adp.lib.util.k.hB()) {
                this.ajh.showToast(w.l.neterror);
            } else if (!this.eLr.Nm()) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aRf();
            } else if (vVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) vVar;
                if (kVar.BP()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aRf() {
        if (this.ajh != null) {
            String[] strArr = {this.ajh.getString(w.l.choose_local_photo), this.ajh.getString(w.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new ad(this));
            cVar.d(this.ajh);
            cVar.tf();
        }
    }

    private void a(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajh != null) {
            String[] strArr = {this.ajh.getString(w.l.hd_photo), this.ajh.getString(w.l.change_photo), this.ajh.getString(w.l.change_system_photo), this.ajh.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new ae(this, kVar, list, i));
            cVar.d(this.ajh);
            cVar.tf();
        }
    }

    private void b(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajh != null) {
            String[] strArr = {this.ajh.getString(w.l.hd_photo), this.ajh.getString(w.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
            cVar.cb(w.l.operation);
            cVar.a(strArr, new af(this, kVar, list, i));
            cVar.d(this.ajh);
            cVar.tf();
        }
    }

    private void c(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.ajh.getString(w.l.look_big_photo), this.ajh.getString(w.l.set_as_portrait_photo), this.ajh.getString(w.l.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.ajh.getPageActivity());
        cVar.cb(w.l.operation);
        cVar.a(strArr, new ag(this, kVar, list, i));
        cVar.d(this.ajh);
        cVar.tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.ajh != null && kVar != null && list != null && !StringUtils.isNull(kVar.BO())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) vVar;
                    if (kVar2.BP()) {
                        arrayList.add(ai.g(this.ajh, kVar2.BO()));
                    } else {
                        arrayList.add(kVar2.BO());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.ajh.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.ajh.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void Q(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.x.r(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.ajh.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eLp)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aRg() {
        if (this.eLr != null && this.eLr.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DH().fH(this.eLr.getUserData().getPortrait());
        }
        this.eLq = true;
    }

    public void jv(boolean z) {
        this.eLs = z;
    }

    public void aRh() {
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eLv, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.eLr != null && this.eLr.getUserData() != null && this.eLr.Nm() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aRg();
        }
    }

    public void aRi() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new ah(this));
    }

    public void Sc() {
        if (this.ajh != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.ajh.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aRj() {
        if (this.ajh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.ajh.getPageActivity(), 12014, this.eLp)));
        }
    }

    public void aRk() {
        if (this.ajh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.ajh.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eLv);
    }
}
