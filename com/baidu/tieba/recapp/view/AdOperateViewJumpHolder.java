package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView ffK;
    private TextView gtr;
    private ImageView gts;
    private Button gtw;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(d.g.ad_operate_title);
        this.ffK = (TextView) this.mRootView.findViewById(d.g.ad_operate_content);
        this.gtr = (TextView) this.mRootView.findViewById(d.g.ad_operate_tag_name);
        this.gts = (ImageView) this.mRootView.findViewById(d.g.ad_operate_divider);
        this.gtw = (Button) this.mRootView.findViewById(d.g.ad_operate_action);
        if (this.gtq == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        int e = s.e(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme);
                        if (AdOperateViewJumpHolder.this.eME != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.eME.b(e, hashMap);
                        }
                    }
                }
            });
            this.gtw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        am.j(this.mRootView, d.C0142d.cp_bg_line_e);
        am.c(this.mTitleTextView, d.C0142d.cp_cont_j, 1);
        am.c(this.ffK, d.C0142d.cp_cont_j, 1);
        am.c(this.gtr, d.C0142d.cp_cont_f, 1);
        am.c(this.gtw, d.C0142d.cp_link_tip_a, 3);
        am.c(this.gts, d.f.ad_divider);
        am.i(this.gtw, d.f.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.goy);
            if (StringUtils.isNull(aVar.goz)) {
                this.ffK.setVisibility(8);
            } else {
                this.ffK.setVisibility(0);
                this.ffK.setText(aVar.goz);
            }
            this.gtr.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(d.k.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.gtq == 2) {
                    this.gtw.setText(getResources().getString(d.k.check_immediately));
                } else if (this.gtq == 1) {
                    this.gtw.setText(getResources().getString(d.k.download));
                } else {
                    this.gtw.setText(getResources().getString(d.k.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.gtq);
                }
            } else {
                this.gtw.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        if (bVar != null) {
            int e = s.e(this.mPageContext, bVar.scheme);
            if (e == 1 || e == 2) {
                if (this.eME != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.eME.b(e, hashMap);
                }
            } else if (this.eME != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.eME.b(bVar.Ue, bVar.Uf, hashMap2);
            }
        }
    }
}
