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
    private TbPageContext GO;
    private com.baidu.tieba.personPolymeric.mode.c eQc;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean eQa = true;
    private boolean eQb = false;
    private boolean eQd = false;
    private HttpMessageListener eQe = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener eQf = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable eQg = new t(this);
    private CustomMessageListener eQh = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        this.GO.registerListener(this.eQh);
        this.GO.registerListener(this.eQf);
        this.GO.registerListener(this.eQe);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(com.baidu.tieba.personPolymeric.mode.c cVar) {
        this.eQc = cVar;
    }

    public List<com.baidu.adp.widget.ListView.v> aVV() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aVV();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aVV() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.holder.d) {
                vVar = ((com.baidu.tieba.person.holder.d) view.getTag()).wX();
            } else if (view.getTag() instanceof com.baidu.tieba.person.holder.c) {
                vVar = ((com.baidu.tieba.person.holder.c) view.getTag()).wX();
            }
            int a = com.baidu.tbadk.core.util.x.a(aVV(), vVar);
            if (a >= 0) {
                a(vVar, aVV(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                this.GO.showToast(r.j.neterror);
            } else if (!this.mPersonPolymericData.aSh()) {
                if (vVar instanceof com.baidu.tbadk.data.l) {
                    b((com.baidu.tbadk.data.l) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aVW();
            } else if (vVar instanceof com.baidu.tbadk.data.l) {
                com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) vVar;
                if (lVar.Cq()) {
                    a(lVar, list, i);
                } else {
                    c(lVar, list, i);
                }
            }
        }
    }

    private void aVW() {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.choose_local_photo), this.GO.getString(r.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.cd(r.j.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.GO);
            cVar.tt();
        }
    }

    private void a(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.hd_photo), this.GO.getString(r.j.change_photo), this.GO.getString(r.j.change_system_photo), this.GO.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.cd(r.j.operation);
            cVar.a(strArr, new w(this, lVar, list, i));
            cVar.d(this.GO);
            cVar.tt();
        }
    }

    private void b(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.hd_photo), this.GO.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.cd(r.j.operation);
            cVar.a(strArr, new x(this, lVar, list, i));
            cVar.d(this.GO);
            cVar.tt();
        }
    }

    private void c(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.GO.getString(r.j.look_big_photo), this.GO.getString(r.j.set_as_portrait_photo), this.GO.getString(r.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
        cVar.cd(r.j.operation);
        cVar.a(strArr, new y(this, lVar, list, i));
        cVar.d(this.GO);
        cVar.tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null && lVar != null && list != null && !StringUtils.isNull(lVar.Cp())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.l) {
                    com.baidu.tbadk.data.l lVar2 = (com.baidu.tbadk.data.l) vVar;
                    if (lVar2.Cq()) {
                        arrayList.add(aa.i(this.GO, lVar2.Cp()));
                    } else {
                        arrayList.add(lVar2.Cp());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void r(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!com.baidu.tbadk.core.util.x.t(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.GO.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.eQa)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aVX() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ep().fY(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.eQb = true;
    }

    public void js(boolean z) {
        this.eQd = z;
    }

    public void aVY() {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eQg, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.aSh() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aVX();
        }
    }

    public void aVZ() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void aWa() {
        if (this.GO != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.GO.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aWb() {
        if (this.GO != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.GO.getPageActivity(), 12014, this.eQa)));
        }
    }

    public void aWc() {
        if (this.GO != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.GO.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eQg);
    }
}
