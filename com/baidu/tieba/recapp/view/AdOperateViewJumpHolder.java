package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView fCT;
    private TextView gRQ;
    private ImageView gRR;
    private Button gRV;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(e.g.ad_operate_title);
        this.fCT = (TextView) this.mRootView.findViewById(e.g.ad_operate_content);
        this.gRQ = (TextView) this.mRootView.findViewById(e.g.ad_operate_tag_name);
        this.gRR = (ImageView) this.mRootView.findViewById(e.g.ad_operate_divider);
        this.gRV = (Button) this.mRootView.findViewById(e.g.ad_operate_action);
        if (this.gRP == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.fnI != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.fnI.b(e, hashMap);
                        }
                    }
                }
            });
            this.gRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        AdOperateViewJumpHolder.this.a(adPost.adData.buttonClick);
                    }
                }
            });
        }
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.c(this.mTitleTextView, e.d.cp_cont_j, 1);
        al.c(this.fCT, e.d.cp_cont_j, 1);
        al.c(this.gRQ, e.d.cp_cont_f, 1);
        al.c(this.gRV, e.d.cp_link_tip_a, 3);
        al.c(this.gRR, e.f.ad_divider);
        al.i(this.gRV, e.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gMV);
            if (StringUtils.isNull(aVar.gMW)) {
                this.fCT.setVisibility(8);
            } else {
                this.fCT.setVisibility(0);
                this.fCT.setText(aVar.gMW);
            }
            this.gRQ.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(e.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gRP == 2) {
                    this.gRV.setText(getResources().getString(e.j.check_immediately));
                } else if (this.gRP == 1) {
                    this.gRV.setText(getResources().getString(e.j.download));
                } else {
                    this.gRV.setText(getResources().getString(e.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gRP);
                }
            } else {
                this.gRV.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.fnI != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.fnI.b(e, hashMap);
                }
            } else if (this.fnI != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.fnI.b(bVar.abf, bVar.abg, hashMap2);
            }
        }
    }
}
