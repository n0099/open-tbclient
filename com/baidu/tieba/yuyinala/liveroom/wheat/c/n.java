package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n {
    private FrameLayout itH;
    private View mView;

    public void a(FrameLayout frameLayout, TextView textView, String str, BdPageContext bdPageContext) {
        if (o.dZA().dYS() || o.dZA().iX(o.dZA().Xm())) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.equals("hide_dot", str)) {
                    hide();
                    textView.setText("");
                    textView.setVisibility(8);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("user_name");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        String optString2 = optJSONObject.optString("msg");
                        int optInt = optJSONObject.optInt("count");
                        if (optInt > 0) {
                            int i = optInt <= 9 ? optInt : 9;
                            textView.setVisibility(0);
                            textView.setText(Integer.toString(i));
                        } else {
                            textView.setText("");
                            textView.setVisibility(8);
                        }
                        if (TextUtils.equals("audio_link_apply_toast", jSONObject.optString("content_type"))) {
                            a(optString + " " + optString2, 0L, 5000, bdPageContext, frameLayout);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        hide();
        textView.setText("");
        textView.setVisibility(8);
    }

    private void a(String str, long j, int i, final BdPageContext bdPageContext, final FrameLayout frameLayout) {
        if (bdPageContext != null && bdPageContext.getPageActivity() != null && frameLayout != null) {
            hide();
            this.mView = bdPageContext.getPageActivity().getLayoutInflater().inflate(a.g.toast_gift_guide, (ViewGroup) null);
            TextView textView = (TextView) this.mView.findViewById(a.f.textView);
            ImageView imageView = (ImageView) this.mView.findViewById(a.f.arrow_imageView);
            textView.setText(str);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_hk);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_hk);
            } else {
                textView.setBackgroundResource(a.e.bg_guide_gift_toast_qm);
                imageView.setImageResource(a.e.bg_guide_gift_toast_arrow_qm);
            }
            this.itH = (FrameLayout) bdPageContext.getPageActivity().getWindow().getDecorView();
            if (this.itH != null) {
                this.itH.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (n.this.itH != null && (pageActivity = bdPageContext.getPageActivity()) != null && !pageActivity.isFinishing()) {
                            FrameLayout frameLayout2 = frameLayout;
                            int[] iArr = new int[2];
                            frameLayout2.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds44)) - (frameLayout2.getWidth() / 2);
                            n.this.mView.measure(0, 0);
                            int measuredHeight = (iArr[1] - n.this.mView.getMeasuredHeight()) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.rightMargin = dimensionPixelSize;
                            layoutParams.topMargin = measuredHeight;
                            layoutParams.gravity = 5;
                            ViewGroup viewGroup = (ViewGroup) n.this.mView.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(n.this.mView);
                            }
                            n.this.itH.addView(n.this.mView, layoutParams);
                        }
                    }
                }, j);
                this.itH.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.itH != null) {
                            n.this.itH.removeView(n.this.mView);
                        }
                    }
                }, i + j);
            }
            this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.n.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    n.this.hide();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.itH != null && this.mView != null) {
            this.itH.removeView(this.mView);
        }
    }
}
