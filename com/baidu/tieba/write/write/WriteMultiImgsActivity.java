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
    private j obL;
    private k oeL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.obL = new j(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void eap() {
                WriteMultiImgsActivity.this.oeL.ebO();
                WriteMultiImgsActivity.this.oeL.zx(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void eaq() {
                WriteMultiImgsActivity.this.oeL.ebT();
                WriteMultiImgsActivity.this.oeL.zx(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean U(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.oeL.W(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void ear() {
                WriteMultiImgsActivity.this.oeL.ear();
            }
        });
        setContentView(this.obL.iGf);
        this.oeL = new k(getPageContext(), this.obL, bundle);
        if (this.oeL.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.oeL.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.oeL != null && this.oeL.oeV != null) {
            bundle.putInt("OutState_Current_Index", this.oeL.oeV.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.oeL.ebR());
            bundle.putSerializable("OutState_Write_Info_Data", this.oeL.cCO());
            this.oeL.oeV.zs(true);
            if (this.oeL.ebU() != null) {
                bundle.putString("OutState_Write_Img_Info", this.oeL.ebU().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ebO() {
        if (this.oeL != null) {
            this.oeL.ebO();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.oeL != null) {
            if (1 == this.oeL.ebR()) {
                ForumWriteData cCO = this.oeL.cCO();
                if (cCO != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, cCO.forumId, cCO.forumName, null, null, 0, cCO.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cCO.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", cCO.mFrom);
                    writeActivityConfig.setCallFrom(cCO.writeCallFrom);
                    writeActivityConfig.setForumLevel(cCO.forumLevel);
                    writeActivityConfig.setForumAvatar(cCO.avatar);
                    writeActivityConfig.setPrivateThread(cCO.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    writeActivityConfig.setFrsTabInfo(cCO.frsTabInfo);
                    writeActivityConfig.setProfessionZone(cCO.defaultZone);
                    writeActivityConfig.setForumDir(cCO.firstDir, cCO.secondDir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.oeL.ebR()) {
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
        if (this.obL != null) {
            this.obL.Ne(i);
        }
        this.oeL.oeV.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.oeL != null) {
            this.oeL.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.obL != null) {
            this.obL.onDestroy();
        }
        super.onDestroy();
    }
}
