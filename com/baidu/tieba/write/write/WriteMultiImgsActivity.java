package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes3.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private j ntx;
    private k nwm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.ntx = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dPl() {
                WriteMultiImgsActivity.this.nwm.dQJ();
                WriteMultiImgsActivity.this.nwm.ym(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dPm() {
                WriteMultiImgsActivity.this.nwm.dQO();
                WriteMultiImgsActivity.this.nwm.ym(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.nwm.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dPn() {
                WriteMultiImgsActivity.this.nwm.dPn();
            }
        });
        setContentView(this.ntx.ibY);
        this.nwm = new k(getPageContext(), this.ntx, bundle);
        if (this.nwm.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.nwm.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.nwm != null && this.nwm.nww != null) {
            bundle.putInt("OutState_Current_Index", this.nwm.nww.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.nwm.dQM());
            bundle.putSerializable("OutState_Write_Info_Data", this.nwm.ctl());
            this.nwm.nww.yg(true);
            if (this.nwm.dQP() != null) {
                bundle.putString("OutState_Write_Img_Info", this.nwm.dQP().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQJ() {
        if (this.nwm != null) {
            this.nwm.dQJ();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.nwm != null) {
            if (1 == this.nwm.dQM()) {
                ForumWriteData ctl = this.nwm.ctl();
                if (ctl != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, ctl.forumId, ctl.forumName, null, null, 0, ctl.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, ctl.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", ctl.mFrom);
                    writeActivityConfig.setCallFrom(ctl.writeCallFrom);
                    writeActivityConfig.setForumLevel(ctl.forumLevel);
                    writeActivityConfig.setForumAvatar(ctl.avatar);
                    writeActivityConfig.setPrivateThread(ctl.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(ctl.frsTabInfo);
                    writeActivityConfig.setProfessionZone(ctl.defaultZone);
                    writeActivityConfig.setForumDir(ctl.firstDir, ctl.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.nwm.dQM()) {
                Intent intent = new Intent(this, WriteActivity.class);
                intent.putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
                intent.setFlags(536870912);
                intent.setFlags(67108864);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (z) {
            if (writeImagesInfo != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("album_result", writeImagesInfo.toJsonString());
                if (!y.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
                    intent2.putExtra("file_name", writeImagesInfo.getChosedFiles().get(0).extra);
                }
                setResult(-1, intent2);
            } else {
                return;
            }
        } else {
            setResult(0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ntx != null) {
            this.ntx.Le(i);
        }
        this.nwm.nww.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.nwm != null) {
            this.nwm.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.ntx != null) {
            this.ntx.onDestroy();
        }
        super.onDestroy();
    }
}
