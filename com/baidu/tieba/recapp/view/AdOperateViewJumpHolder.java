package com.baidu.tieba.recapp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView aFh;
    private View mRootView;
    private TextView mTitleTextView;
    private Button mzC;
    private TextView mzx;
    private ImageView mzy;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.aFh = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.mzx = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.mzy = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.mzC = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.mzw == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = adPost.getAdvertAppInfo().eyO;
                        }
                        int c = s.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.kFA != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.kFA.d(c, hashMap);
                        }
                    }
                }
            });
            this.mzC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.mTitleTextView, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.aFh, R.color.cp_cont_j, 1);
        ap.setViewTextColor(this.mzx, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.mzC, R.color.cp_link_tip_a, 3);
        ap.setImageResource(this.mzy, R.drawable.ad_divider);
        ap.setBackgroundResource(this.mzC, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.Zt);
            if (StringUtils.isNull(aVar.muI)) {
                this.aFh.setVisibility(8);
            } else {
                this.aFh.setVisibility(0);
                this.aFh.setText(aVar.muI);
            }
            this.mzx.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.mzw == 2) {
                    this.mzC.setText(getResources().getString(R.string.check_immediately));
                } else if (this.mzw == 1) {
                    this.mzC.setText(getResources().getString(R.string.download));
                } else {
                    this.mzC.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.mzw);
                }
            } else {
                this.mzC.setText(aVar.buttonText);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostAdBaseData.a.b bVar) {
        String str;
        if (bVar != null) {
            AdPost adPost = (AdPost) getTag();
            if (adPost == null || adPost.getAdvertAppInfo() == null) {
                str = null;
            } else {
                str = adPost.getAdvertAppInfo().eyO;
            }
            int c = s.c(this.mPageContext, bVar.scheme, str);
            if (c == 1 || c == 2) {
                if (this.kFA != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.kFA.d(c, hashMap);
                }
            } else if (this.kFA != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.kFA.a(bVar.auR, bVar.auS, hashMap2);
            }
        }
    }
}
