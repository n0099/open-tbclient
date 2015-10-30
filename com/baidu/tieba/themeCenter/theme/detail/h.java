package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ f dhd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.dhd = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        SkinDetailActivity skinDetailActivity;
        SkinDetailActivity skinDetailActivity2;
        c cVar2;
        TiebaStatic.log("c10277");
        cVar = this.dhd.dhb;
        cVar.getItem(i);
        skinDetailActivity = this.dhd.dgY;
        skinDetailActivity2 = this.dhd.dgY;
        ImageViewerConfig imageViewerConfig = new ImageViewerConfig(skinDetailActivity2.getPageContext().getPageActivity());
        cVar2 = this.dhd.dhb;
        skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, imageViewerConfig.createConfig(cVar2.azz(), i, null, "", "", true, "", true)));
    }
}
