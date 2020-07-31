package com.baidu.tieba.recapp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.s;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class AdOperateViewJumpHolder extends AdOperateBarHolder<AdPost> {
    private static final String TAG = AdOperateViewJumpHolder.class.getSimpleName();
    private TextView avu;
    private TextView lsg;
    private ImageView lsh;
    private Button lsl;
    private View mRootView;
    private TextView mTitleTextView;

    public AdOperateViewJumpHolder(TbPageContext tbPageContext, int i, View view) {
        super(tbPageContext, i, view);
        this.mRootView = view;
        init();
    }

    private void init() {
        this.mTitleTextView = (TextView) this.mRootView.findViewById(R.id.ad_operate_title);
        this.avu = (TextView) this.mRootView.findViewById(R.id.ad_operate_content);
        this.lsg = (TextView) this.mRootView.findViewById(R.id.ad_operate_tag_name);
        this.lsh = (ImageView) this.mRootView.findViewById(R.id.ad_operate_divider);
        this.lsl = (Button) this.mRootView.findViewById(R.id.ad_operate_action);
        if (this.lsf == 2) {
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdPost adPost = (AdPost) AdOperateViewJumpHolder.this.getTag();
                    if (adPost != null && adPost.adData != null) {
                        String str = null;
                        if (adPost.getAdvertAppInfo() != null) {
                            str = adPost.getAdvertAppInfo().dMW;
                        }
                        int c = s.c(AdOperateViewJumpHolder.this.mPageContext, adPost.adData.scheme, str);
                        if (AdOperateViewJumpHolder.this.jzO != null) {
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("da_area", "adarea");
                            AdOperateViewJumpHolder.this.jzO.d(c, hashMap);
                        }
                    }
                }
            });
            this.lsl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.AdOperateViewJumpHolder.2
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
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.mTitleTextView, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.avu, R.color.cp_cont_j, 1);
        ao.setViewTextColor(this.lsg, R.color.cp_cont_f, 1);
        ao.setViewTextColor(this.lsl, R.color.cp_link_tip_a, 3);
        ao.setImageResource(this.lsh, R.drawable.ad_divider);
        ao.setBackgroundResource(this.lsl, R.drawable.feed_ad_progress_button_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.view.AdOperateBarHolder
    public void update(AdPost adPost) {
        super.update((AdOperateViewJumpHolder) adPost);
        if (adPost != null && isOperateValid(adPost.adData)) {
            PostAdBaseData.a aVar = adPost.adData;
            this.mTitleTextView.setText(aVar.Yb);
            if (StringUtils.isNull(aVar.lno)) {
                this.avu.setVisibility(8);
            } else {
                this.avu.setVisibility(0);
                this.avu.setText(aVar.lno);
            }
            this.lsg.setText(StringUtils.isNull(aVar.tagName) ? getResources().getString(R.string.advert_label) : aVar.tagName);
            if (StringUtils.isNull(aVar.buttonText)) {
                if (this.lsf == 2) {
                    this.lsl.setText(getResources().getString(R.string.check_immediately));
                } else if (this.lsf == 1) {
                    this.lsl.setText(getResources().getString(R.string.download));
                } else {
                    this.lsl.setText(getResources().getString(R.string.check_immediately));
                    Log.e(TAG, "invalid operate type: " + this.lsf);
                }
            } else {
                this.lsl.setText(aVar.buttonText);
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
                str = adPost.getAdvertAppInfo().dMW;
            }
            int c = s.c(this.mPageContext, bVar.scheme, str);
            if (c == 1 || c == 2) {
                if (this.jzO != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("da_area", "adarea");
                    this.jzO.d(c, hashMap);
                }
            } else if (this.jzO != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("da_area", "adarea");
                this.jzO.a(bVar.aoF, bVar.aoG, hashMap2);
            }
        }
    }
}
