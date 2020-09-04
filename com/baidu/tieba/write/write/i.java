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
    private TbPageContext<WriteActivity> efr;
    private WriteImageGridView mWK;
    public h mWL;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tbadk.img.b eLP = new com.baidu.tbadk.img.b();
    private String mFrom = "write";
    private String mForumId = "";
    private h.a mWN = new h.a() { // from class: com.baidu.tieba.write.write.i.1
        @Override // com.baidu.tieba.write.write.h.a
        public void JI(int i) {
            if (i.this.mWriteImagesInfo != null && i.this.mWriteImagesInfo.getChosedFiles() != null && i >= 0 && i < i.this.mWriteImagesInfo.getChosedFiles().size()) {
                ImageFileInfo remove = i.this.mWriteImagesInfo.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    com.baidu.adp.lib.Disk.d.lG().c(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                i.this.mWL.a(i.this.mWriteImagesInfo);
                i.this.mWL.notifyDataSetChanged();
                if (y.isEmpty(i.this.mWriteImagesInfo.getChosedFiles()) && i.this.efr.getOrignalPage() != 0) {
                    ((WriteActivity) i.this.efr.getOrignalPage()).dtm();
                }
                if (i.this.efr.getPageActivity() instanceof WriteActivity) {
                    ((WriteActivity) i.this.efr.getPageActivity()).dIM();
                }
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void JS(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.mWriteImagesInfo != null && (count = y.getCount(i.this.mWriteImagesInfo.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = i.this.mWriteImagesInfo.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                i.this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(i.this.efr.getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, i.this.mWriteImagesInfo, i)));
            }
        }

        @Override // com.baidu.tieba.write.write.h.a
        public void dIX() {
            if (i.this.mWriteImagesInfo != null) {
                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.efr.getPageActivity(), i.this.mWriteImagesInfo.toJsonString(), true, true);
                albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.mForumId);
                albumFloatActivityConfig.getIntent().putExtra("from", i.this.mFrom);
                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                if (i.this.efr.getPageActivity() instanceof WriteActivity) {
                    albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.efr.getPageActivity()).dGk());
                    AntiData antiData = new AntiData();
                    antiData.voice_message = ((WriteActivity) i.this.efr.getPageActivity()).eMx;
                    antiData.setIfVoice(((WriteActivity) i.this.efr.getPageActivity()).mVr);
                    albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.efr.getPageActivity()).mPrefixData, ((WriteActivity) i.this.efr.getPageActivity()).lUv.getFirstDir(), ((WriteActivity) i.this.efr.getPageActivity()).lUv.getSecondDir());
                }
                albumFloatActivityConfig.setFromWrite(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
            }
        }
    };

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.efr = tbPageContext;
        this.mWK = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        this.mWL = new h(view.getContext(), this.eLP, null, this.mWN);
        this.mWK.setAdapter((ListAdapter) this.mWL);
    }

    public void a(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.mFrom = str;
        this.mForumId = str2;
        this.mWriteImagesInfo = writeImagesInfo;
        this.mWL.a(this.mWriteImagesInfo);
        this.mWL.notifyDataSetChanged();
    }

    public GridView dIY() {
        return this.mWK;
    }

    public void destroy() {
        this.eLP.cancelAllAsyncTask();
    }

    public void xg(boolean z) {
        this.mWL.xg(z);
    }
}
