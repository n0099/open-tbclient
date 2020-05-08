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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes2.dex */
public class WriteMultiImgsActivity extends BaseActivity {
    private h lDO;
    private i lFY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.lDO = new h(getPageContext(), new com.baidu.tieba.write.write.sticker.a.c() { // from class: com.baidu.tieba.write.write.WriteMultiImgsActivity.1
            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgG() {
                WriteMultiImgsActivity.this.lFY.dhK();
                WriteMultiImgsActivity.this.lFY.vf(true);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgH() {
                WriteMultiImgsActivity.this.lFY.dhP();
                WriteMultiImgsActivity.this.lFY.vf(false);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public boolean Q(Bitmap bitmap) {
                return WriteMultiImgsActivity.this.lFY.S(bitmap);
            }

            @Override // com.baidu.tieba.write.write.sticker.a.c
            public void dgI() {
                WriteMultiImgsActivity.this.lFY.dgI();
            }
        });
        setContentView(this.lDO.gLM);
        this.lFY = new i(getPageContext(), this.lDO, bundle);
        if (this.lFY.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            TbadkCoreApplication.getInst().setSkinType(this.lFY.mSkinType);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.lFY != null && this.lFY.lGi != null) {
            bundle.putInt("OutState_Current_Index", this.lFY.lGi.getCurrentIndex());
            bundle.putInt("OutState_Write_Entrance", this.lFY.dhN());
            bundle.putSerializable("OutState_Write_Info_Data", this.lFY.bPa());
            this.lFY.lGi.va(true);
            if (this.lFY.dhQ() != null) {
                bundle.putString("OutState_Write_Img_Info", this.lFY.dhQ().toJsonString());
            }
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dhK() {
        if (this.lFY != null) {
            this.lFY.dhK();
        }
    }

    public void a(boolean z, WriteImagesInfo writeImagesInfo) {
        if (this.lFY != null) {
            if (1 == this.lFY.dhN()) {
                ForumWriteData bPa = this.lFY.bPa();
                if (bPa != null) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 10, bPa.forumId, bPa.forumName, null, null, 0, bPa.antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bPa.prefixData, 0);
                    writeActivityConfig.getIntent().putExtra("from", bPa.mFrom);
                    writeActivityConfig.setCallFrom(bPa.writeCallFrom);
                    writeActivityConfig.setForumLevel(bPa.forumLevel);
                    writeActivityConfig.setForumAvatar(bPa.avatar);
                    writeActivityConfig.setPrivateThread(bPa.privateThread);
                    writeActivityConfig.setWriteImagesInfo(writeImagesInfo);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            } else if (2 == this.lFY.dhN()) {
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
                if (!v.isEmpty(writeImagesInfo.getChosedFiles()) && writeImagesInfo.getChosedFiles().get(0) != null) {
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
        if (this.lDO != null) {
            this.lDO.Fe(i);
        }
        this.lFY.lGi.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lFY != null) {
            this.lFY.destroy();
        }
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        if (this.lDO != null) {
            this.lDO.onDestroy();
        }
        super.onDestroy();
    }
}
