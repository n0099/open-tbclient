package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static e oGu;
    private FrameLayout iSP;
    private View mView;
    private long nWt;
    private long oGv = -1;

    private e() {
    }

    public static e edq() {
        if (oGu == null) {
            synchronized (e.class) {
                if (oGu == null) {
                    oGu = new e();
                }
            }
        }
        return oGu;
    }

    public void a(final View view, TextView textView, String str, final BdPageContext bdPageContext) {
        JSONObject optJSONObject;
        if (q.edM().Yk() || q.edM().iJ(q.edM().Yp())) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.equals("hide_dot", str)) {
                    hide();
                    textView.setText("");
                    textView.setVisibility(8);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    final String optString = jSONObject.optString("user_name");
                    String optString2 = jSONObject.optString("room_id");
                    if (com.baidu.live.ao.a.Yj().Yq() != null && com.baidu.live.ao.a.Yj().Yq().aIU != null && TextUtils.equals(optString2, com.baidu.live.ao.a.Yj().Yq().aIU.aTK) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        final String optString3 = optJSONObject.optString("msg");
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
                            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.a(optString + " " + optString3, 0L, 5000, bdPageContext, view);
                                    e.this.oGv = 0L;
                                }
                            }, C(0, 5000L));
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

    public void a(final View view, final int i, final BdPageContext bdPageContext, ab abVar) {
        final int i2 = 5;
        if (abVar != null && abVar.aJv != 0) {
            if (abVar != null && abVar.aJu > 0) {
                i2 = abVar.aJu;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.a(String.format("查看%d个新麦位框", Integer.valueOf(i)), 0L, i2 * 1000, bdPageContext, view);
                    e.this.oGv = 1L;
                }
            }, C(1, i2 * 1000));
        }
    }

    private long C(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.oGv == -1 || this.oGv == i || currentTimeMillis - this.nWt >= j) {
            return 0L;
        }
        return (j - (currentTimeMillis - this.nWt)) + 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, int i, final BdPageContext bdPageContext, final View view) {
        if (bdPageContext != null && bdPageContext.getPageActivity() != null && view != null) {
            this.nWt = System.currentTimeMillis();
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
            this.iSP = (FrameLayout) bdPageContext.getPageActivity().getWindow().getDecorView();
            if (this.iSP != null) {
                this.iSP.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity pageActivity;
                        if (e.this.iSP != null && (pageActivity = bdPageContext.getPageActivity()) != null && !pageActivity.isFinishing()) {
                            View view2 = view;
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            int dimensionPixelSize = ((BdUtilHelper.getScreenSize(pageActivity).widthPixels - iArr[0]) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds44)) - (view2.getWidth() / 2);
                            e.this.mView.measure(0, 0);
                            int measuredHeight = (iArr[1] - e.this.mView.getMeasuredHeight()) - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.rightMargin = dimensionPixelSize;
                            layoutParams.topMargin = measuredHeight;
                            layoutParams.gravity = 5;
                            ViewGroup viewGroup = (ViewGroup) e.this.mView.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(e.this.mView);
                            }
                            e.this.iSP.addView(e.this.mView, layoutParams);
                        }
                    }
                }, j);
                this.iSP.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.iSP != null) {
                            e.this.iSP.removeView(e.this.mView);
                        }
                    }
                }, i + j);
            }
            this.mView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.e.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.hide();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.iSP != null && this.mView != null) {
            this.iSP.removeView(this.mView);
        }
    }
}
