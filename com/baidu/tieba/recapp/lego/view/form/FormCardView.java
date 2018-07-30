package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.a.b;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private int bbG;
    private TitleView gsn;
    private CommitView gso;
    private LinearLayout gsp;
    private LinearLayout gsq;
    private ImageView gsr;
    private TextView gss;
    private TextView gst;
    private FormCard gsu;
    private List<a> gsv;
    private String gsw;
    private float gsx;
    private int gsy;
    private Activity mActivity;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        boolean bnO();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gsw = "";
        this.mScreenWidth = 0;
        this.bbG = 0;
        this.gsx = 1.0f;
        this.gsy = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.ah(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRx() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(d.h.card_form, (ViewGroup) null);
        this.gsn = (TitleView) this.mRootView.findViewById(d.g.form_title_view);
        this.gsr = (ImageView) this.mRootView.findViewById(d.g.tb_img_background);
        this.gsr.setEnabled(false);
        this.gso = (CommitView) this.mRootView.findViewById(d.g.form_commit_view);
        this.gsq = (LinearLayout) this.mRootView.findViewById(d.g.item_content_view);
        this.gsp = (LinearLayout) this.mRootView.findViewById(d.g.form_commit_success_view);
        this.gss = (TextView) this.mRootView.findViewById(d.g.form_success_title);
        this.gst = (TextView) this.mRootView.findViewById(d.g.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.gso != null) {
            this.gso.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.b(FormCardView.this.gsv, FormCardView.this.gso.getPostUrl(), FormCardView.this.gsw);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(FormCard formCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.gsu != formCard) {
            bnV();
            this.gsu = formCard;
            this.gsw = formCard.getItemId();
            bB(formCard.mWidth, formCard.mHeight);
            this.gsn.aC(this.gsx);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsn.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gsx);
            }
            this.gso.aC(this.gsx);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gso.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size90)) * this.gsx);
            }
            this.gsn.a(formCard.titleInfo);
            this.gso.a(formCard.commitInfo);
            b.bno().a(new com.baidu.tieba.recapp.a.a(this.gso.getPostUrl()));
            bnS();
            bnU();
            bnT();
            a(this.gsn);
            a(this.gso);
            if (formCard.isCommitSuccess()) {
                bnW();
            }
            if (!formCard.mHasShown) {
                r.bnn().bnj().az(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void bB(int i, int i2) {
        this.bbG = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.bbG;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.gsx = (float) (this.mScreenWidth / 750.0d);
    }

    private void bnS() {
        this.mRootView.setBackgroundResource(d.f.form_defalut_bg_image);
        if (this.gsu.backgroundInfo != null) {
            this.gsr.setVisibility(0);
            if (!TextUtils.isEmpty(this.gsu.backgroundInfo.img)) {
                c.ih().a(this.gsu.backgroundInfo.img, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.nb() != null) {
                                    int height = aVar.nb().getHeight();
                                    int width = aVar.nb().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.gsu.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.gsr.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gsr.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.gsr.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.gsr.getLayoutParams().height = FormCardView.this.bbG;
                                                break;
                                        }
                                        int parseColor = com.baidu.tieba.lego.card.d.a.parseColor(FormCardView.this.gsu.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.pc(parseColor)) {
                                            FormCardView.this.mRootView.setBackgroundColor(parseColor);
                                        }
                                        aVar.a(FormCardView.this.gsr);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.gsr.setImageBitmap(null);
                                FormCardView.this.gsr.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.gsr.setImageBitmap(null);
                                FormCardView.this.gsr.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.gsr.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.gsr.setVisibility(8);
    }

    private void bnT() {
        FormCard.f fVar = this.gsu.resultInfo;
        float dimension = this.mContext.getResources().getDimension(d.e.fontsize48);
        float dimension2 = this.mContext.getResources().getDimension(d.e.fontsize28);
        int color = this.mContext.getResources().getColor(d.C0140d.form_font_color);
        if (fVar != null) {
            this.gss.setText(fVar.title);
            this.gss.setTextColor(-1);
            this.gss.setTextSize(0, dimension);
            this.gst.setText(fVar.desc);
            this.gst.setTextColor(color);
            this.gst.setTextSize(0, dimension2);
        }
    }

    private void bnU() {
        if (this.gsu.itemList != null && this.gsu.itemList.size() > 0) {
            int size = this.gsu.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.gsu.itemList.get(i);
                if (bVar != null) {
                    switch (bVar.type) {
                        case 1:
                            a(bVar, new TitleView(this.mActivity), i, size);
                            continue;
                        case 2:
                            a(bVar, new CommitView(this.mActivity), i, size);
                            continue;
                        case 3:
                        case 4:
                        case 5:
                            a(bVar, new EditView(this.mActivity), i, size);
                            continue;
                        case 6:
                        case 7:
                        case 8:
                            a(bVar, new PickerView(this.mActivity), i, size);
                            continue;
                    }
                }
            }
        }
    }

    private void bnV() {
        this.gsq.removeAllViews();
        if (this.gsv != null) {
            this.gsv.clear();
        } else {
            this.gsv = new ArrayList();
        }
        this.gso.setVisibility(0);
        this.gsq.setVisibility(0);
        this.gsp.setVisibility(8);
        this.gso.setClickable(true);
        this.gsr.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aC(this.gsx);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.gsq.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.bnX());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(d.e.form_size40)) * this.gsx);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.bnX()));
        }
    }

    public void a(a aVar) {
        if (this.gsv == null) {
            this.gsv = new ArrayList();
        }
        this.gsv.add(aVar);
    }

    public void b(List<a> list, String str, String str2) {
        JSONObject bZ;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.bnO()) {
                        View frameView = formView.getFrameView();
                        if (frameView != null) {
                            formView.a(frameView, FormItemBaseView.DrawableType.ERROR_FRAME);
                        }
                        z = false;
                        z2 = z;
                    } else {
                        View frameView2 = formView.getFrameView();
                        if (frameView2 != null) {
                            formView.a(frameView2, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                        }
                    }
                }
                z = z2;
                z2 = z;
            }
            if (z2) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar2 : list) {
                    FormItemBaseView formView2 = aVar2.getFormView();
                    if (formView2 != null && (bZ = bZ(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(bZ);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                c(str, hashMap);
                this.gso.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.d().showToast(d.f.icon_toast_game_error, d.j.form_commit_error_string);
            this.gso.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnW() {
        this.gso.setVisibility(4);
        this.gsq.setVisibility(4);
        this.gsp.setVisibility(0);
    }

    private JSONObject bZ(String str, String str2) {
        if (TextUtils.equals(str2, "NEGLIGIBLE")) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", str);
            jSONObject.put("value", str2);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private void c(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.gso.setClickable(true);
        } else {
            b.bno().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.ZQ) {
                            FormCardView.this.gsu.setCommitState(true);
                            FormCardView.this.bnW();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.d().f(hVar.errorString);
                            FormCardView.this.gsu.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.d().showToast(d.f.icon_toast_game_error, d.j.form_commit_fail_string);
                            FormCardView.this.gsu.setCommitState(false);
                        }
                    }
                    FormCardView.this.gso.setClickable(true);
                }
            });
        }
    }
}
