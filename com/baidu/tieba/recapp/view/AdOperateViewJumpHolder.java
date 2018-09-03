package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView ffK;
    private TextView guH;
    private ImageView guI;
    private Button guM;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(f.g.ad_operate_title);
        this.ffK = (TextView) this.mRootView.findViewById(f.g.ad_operate_content);
        this.guH = (TextView) this.mRootView.findViewById(f.g.ad_operate_tag_name);
        this.guI = (ImageView) this.mRootView.findViewById(f.g.ad_operate_divider);
        this.guM = (Button) this.mRootView.findViewById(f.g.ad_operate_action);
        if (this.guG == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.eQu != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.eQu.b(e, hashMap);
                        }
                    }
                }
            });
            this.guM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        am.j(this.mRootView, f.d.cp_bg_line_e);
        am.c(this.mTitleTextView, f.d.cp_cont_j, 1);
        am.c(this.ffK, f.d.cp_cont_j, 1);
        am.c(this.guH, f.d.cp_cont_f, 1);
        am.c(this.guM, f.d.cp_link_tip_a, 3);
        am.c(this.guI, f.C0146f.ad_divider);
        am.i(this.guM, f.C0146f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.gpL);
            if (StringUtils.isNull(aVar.gpM)) {
                this.ffK.setVisibility(8);
            } else {
                this.ffK.setVisibility(0);
                this.ffK.setText(aVar.gpM);
            }
            this.guH.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(f.j.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.guG == 2) {
                    this.guM.setText(getResources().getString(f.j.check_immediately));
                } else if (this.guG == 1) {
                    this.guM.setText(getResources().getString(f.j.download));
                } else {
                    this.guM.setText(getResources().getString(f.j.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.guG);
                }
            } else {
                this.guM.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.eQu != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.eQu.b(e, hashMap);
                }
            } else if (this.eQu != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.eQu.b(bVar.Ua, bVar.Ub, hashMap2);
            }
        }
    }
}
