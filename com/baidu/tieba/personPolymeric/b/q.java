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
    private com.baidu.tieba.personPolymeric.mode.c etB;
    private PersonChangeData mPersonChangeData;
    private com.baidu.tieba.personPolymeric.c.n mPersonPolymericData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean etz = true;
    private boolean etA = false;
    private boolean etC = false;
    private HttpMessageListener etD = new r(this, CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    private HttpMessageListener etE = new s(this, CmdConfigHttp.CMD_SET_USER_PICS);
    private Runnable etF = new t(this);
    private CustomMessageListener etG = new u(this, CmdConfigCustom.CMD_PERSON_DATA_CHANGED);

    public q(TbPageContext tbPageContext) {
        this.GO = tbPageContext;
        this.GO.registerListener(this.etG);
        this.GO.registerListener(this.etE);
        this.GO.registerListener(this.etD);
    }

    public void b(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mPersonPolymericData = nVar;
    }

    public void a(com.baidu.tieba.personPolymeric.mode.c cVar) {
        this.etB = cVar;
    }

    public List<com.baidu.adp.widget.ListView.v> aPF() {
        if (this.mPersonPolymericData == null) {
            return null;
        }
        return this.mPersonPolymericData.aPF();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aPF() != null) {
            com.baidu.adp.widget.ListView.v vVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.holder.d) {
                vVar = ((com.baidu.tieba.person.holder.d) view.getTag()).wK();
            } else if (view.getTag() instanceof com.baidu.tieba.person.holder.c) {
                vVar = ((com.baidu.tieba.person.holder.c) view.getTag()).wK();
            }
            int a = com.baidu.tbadk.core.util.x.a(aPF(), vVar);
            if (a >= 0) {
                a(vVar, aPF(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (vVar != null && this.mPersonPolymericData != null) {
            if (!com.baidu.adp.lib.util.k.gD()) {
                this.GO.showToast(r.j.neterror);
            } else if (!this.mPersonPolymericData.aMb()) {
                if (vVar instanceof com.baidu.tbadk.data.l) {
                    b((com.baidu.tbadk.data.l) vVar, list, i);
                }
            } else if (vVar instanceof com.baidu.tieba.person.data.a) {
                aPG();
            } else if (vVar instanceof com.baidu.tbadk.data.l) {
                com.baidu.tbadk.data.l lVar = (com.baidu.tbadk.data.l) vVar;
                if (lVar.Cd()) {
                    a(lVar, list, i);
                } else {
                    c(lVar, list, i);
                }
            }
        }
    }

    private void aPG() {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.choose_local_photo), this.GO.getString(r.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.ce(r.j.operation);
            cVar.a(strArr, new v(this));
            cVar.d(this.GO);
            cVar.te();
        }
    }

    private void a(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.hd_photo), this.GO.getString(r.j.change_photo), this.GO.getString(r.j.change_system_photo), this.GO.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.ce(r.j.operation);
            cVar.a(strArr, new w(this, lVar, list, i));
            cVar.d(this.GO);
            cVar.te();
        }
    }

    private void b(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null) {
            String[] strArr = {this.GO.getString(r.j.hd_photo), this.GO.getString(r.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
            cVar.ce(r.j.operation);
            cVar.a(strArr, new x(this, lVar, list, i));
            cVar.d(this.GO);
            cVar.te();
        }
    }

    private void c(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        String[] strArr = {this.GO.getString(r.j.look_big_photo), this.GO.getString(r.j.set_as_portrait_photo), this.GO.getString(r.j.delete)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.GO.getPageActivity());
        cVar.ce(r.j.operation);
        cVar.a(strArr, new y(this, lVar, list, i));
        cVar.d(this.GO);
        cVar.te();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.l lVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        if (this.GO != null && lVar != null && list != null && !StringUtils.isNull(lVar.Cc())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.data.l) {
                    com.baidu.tbadk.data.l lVar2 = (com.baidu.tbadk.data.l) vVar;
                    if (lVar2.Cd()) {
                        arrayList.add(aa.i(this.GO, lVar2.Cc()));
                    } else {
                        arrayList.add(lVar2.Cc());
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.GO.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.etz)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aPH() {
        if (this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DX().fU(this.mPersonPolymericData.getUserData().getPortrait());
        }
        this.etA = true;
    }

    public void jd(boolean z) {
        this.etC = z;
    }

    public void aPI() {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.etF, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.mPersonPolymericData != null && this.mPersonPolymericData.getUserData() != null && this.mPersonPolymericData.aMb() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aPH();
        }
    }

    public void aPJ() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new z(this));
    }

    public void aPK() {
        if (this.GO != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.GO.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aPL() {
        if (this.GO != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.GO.getPageActivity(), 12014, this.etz)));
        }
    }

    public void aPM() {
        if (this.GO != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.GO.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.etF);
    }
}
