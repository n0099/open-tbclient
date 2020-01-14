package com.baidu.tieba.recapp.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
/* loaded from: classes11.dex */
public class AdOperateBarCreator {
    private final TbPageContext mTbPageContext;

    public AdOperateBarCreator(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public AdOperateBarHolder obtainHolder(AdPost adPost, RelativeLayout relativeLayout, AdOperateBarHolder adOperateBarHolder, c cVar) {
        if (adPost != null && adPost.adData != null) {
            if (adOperateBarHolder != null && bq(adPost.adData.style, adOperateBarHolder.jLG)) {
                adOperateBarHolder.setDownloadAppCallback(cVar);
                return adOperateBarHolder;
            } else if (relativeLayout == null) {
                return null;
            } else {
                relativeLayout.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(adPost.adData.style)) {
                    return new AdOperateViewJumpHolder(this.mTbPageContext, 2, LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ad_operate_view_layout, (ViewGroup) relativeLayout, true));
                } else if ("apk_download".equals(adPost.adData.style)) {
                    AdOperateViewDownloadHolder adOperateViewDownloadHolder = new AdOperateViewDownloadHolder(this.mTbPageContext, 1, LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ad_operate_view_download_layout, (ViewGroup) relativeLayout, true));
                    adOperateViewDownloadHolder.setDownloadAppCallback(cVar);
                    return adOperateViewDownloadHolder;
                } else {
                    return null;
                }
            }
        }
        return adOperateBarHolder;
    }

    private boolean bq(String str, int i) {
        return "apk_download".equals(str) ? i == 1 : TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str) && i == 2;
    }
}
