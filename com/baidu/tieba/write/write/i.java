package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.h;
/* loaded from: classes3.dex */
public class i {
    private TbPageContext<WriteActivity> efn;
    private WriteImagesInfo mWriteImagesInfo;
    private WriteImageGridView mWs;
    public h mWt;
    private com.baidu.tbadk.img.b eLL = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a mWu = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void JI(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.mWt.a(i.this.mWriteImagesInfo);
                i.this.mWt.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.efn.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.efn.getOrignalPage()).dth();
                }
                if (i.this.efn.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.efn.getPageActivity()).dID();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void JS(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.efn.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dIO() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.efn.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.efn.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.efn.getPageActivity()).dGb());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.efn.getPageActivity()).eMt;
                    antiData.setIfVoice(((WriteActivity) i.this.efn.getPageActivity()).mUZ);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.efn.getPageActivity()).mPrefixData, ((WriteActivity) i.this.efn.getPageActivity()).lUg.getFirstDir(), ((WriteActivity) i.this.efn.getPageActivity()).lUg.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.efn = tbPageContext;
        this.mWs = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.mWt = new h(view.getContext(), this.eLL, null, this.mWu);
        this.mWs.setAdapter((ListAdapter) this.mWt);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.mWt.a(this.mWriteImagesInfo);
        this.mWt.notifyDataSetChanged();
    }

    public GridView dIP() {
        return this.mWs;
    }

    public void destroy() {
        this.eLL.cancelAllAsyncTask();
    }

    public void xe(boolean z) {
        this.mWt.xe(z);
    }
}
