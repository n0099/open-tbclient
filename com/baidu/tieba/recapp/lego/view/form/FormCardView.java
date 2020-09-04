package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.R;
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
/* loaded from: classes20.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aOJ;
    private List<a> lGA;
    private float lGB;
    private int lGC;
    private TitleView lGs;
    private CommitView lGt;
    private LinearLayout lGu;
    private LinearLayout lGv;
    private ImageView lGw;
    private TextView lGx;
    private TextView lGy;
    private FormCard lGz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes20.dex */
    public interface a {
        boolean dnL();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aOJ = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.lGB = 1.0f;
        this.lGC = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMq() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.lGs = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.lGw = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.lGw.setEnabled(false);
        this.lGt = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.lGv = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.lGu = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.lGx = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.lGy = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.lGt != null) {
            this.lGt.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.lGA, FormCardView.this.lGt.getPostUrl(), FormCardView.this.aOJ);
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
    public void d(FormCard formCard) {
        if (formCard != null && formCard.mIsLegal && this.lGz != formCard) {
            dnS();
            this.lGz = formCard;
            this.aOJ = formCard.getItemId();
            dd(formCard.mWidth, formCard.mHeight);
            this.lGs.aC(this.lGB);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGs.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lGB);
            }
            this.lGt.aC(this.lGB);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lGt.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.lGB);
            }
            this.lGs.a(formCard.titleInfo);
            this.lGt.a(formCard.commitInfo);
            b.dnl().a(new com.baidu.tieba.recapp.a.a(this.lGt.getPostUrl()));
            dnP();
            dnR();
            dnQ();
            a(this.lGs);
            a(this.lGt);
            if (formCard.isCommitSuccess()) {
                dnT();
            }
            if (!formCard.mHasShown) {
                r.dnk().dng().dO(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void dd(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.lGB = (float) (this.mScreenWidth / 750.0d);
    }

    private void dnP() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.lGz.backgroundInfo != null) {
            this.lGw.setVisibility(0);
            if (!TextUtils.isEmpty(this.lGz.backgroundInfo.img)) {
                c.mM().a(this.lGz.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass2) aVar, str, i);
                        if (aVar != null) {
                            try {
                                if (aVar.getRawBitmap() != null) {
                                    int height = aVar.getRawBitmap().getHeight();
                                    int width = aVar.getRawBitmap().getWidth();
                                    if (width != 0) {
                                        int i2 = (height * FormCardView.this.mScreenWidth) / width;
                                        switch (FormCardView.this.lGz.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.lGw.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lGw.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.lGw.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.lGw.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int fo = com.baidu.tieba.lego.card.d.b.fo(FormCardView.this.lGz.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.b.Cn(fo)) {
                                            FormCardView.this.mRootView.setBackgroundColor(fo);
                                        }
                                        aVar.drawImageTo(FormCardView.this.lGw);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.lGw.setImageBitmap(null);
                                FormCardView.this.lGw.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.lGw.setImageBitmap(null);
                                FormCardView.this.lGw.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.lGw.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.lGw.setVisibility(8);
    }

    private void dnQ() {
        FormCard.f fVar = this.lGz.resultInfo;
        float dimension = this.efr.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.efr.getResources().getDimension(R.dimen.fontsize28);
        int color = this.efr.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.lGx.setText(fVar.title);
            this.lGx.setTextColor(-1);
            this.lGx.setTextSize(0, dimension);
            this.lGy.setText(fVar.desc);
            this.lGy.setTextColor(color);
            this.lGy.setTextSize(0, dimension2);
        }
    }

    private void dnR() {
        if (this.lGz.itemList != null && this.lGz.itemList.size() > 0) {
            int size = this.lGz.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.lGz.itemList.get(i);
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

    private void dnS() {
        this.lGv.removeAllViews();
        if (this.lGA != null) {
            com.baidu.tieba.lego.card.d.a.clear(this.lGA);
        } else {
            this.lGA = new ArrayList();
        }
        this.lGt.setVisibility(0);
        this.lGv.setVisibility(0);
        this.lGu.setVisibility(8);
        this.lGt.setClickable(true);
        this.lGw.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aC(this.lGB);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.lGv.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.dnU());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.lGB);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.dnU()));
        }
    }

    public void a(a aVar) {
        if (this.lGA == null) {
            this.lGA = new ArrayList();
        }
        com.baidu.tieba.lego.card.d.a.a(this.lGA, aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject fF;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.dnL()) {
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
                    if (formView2 != null && (fF = fF(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(fF);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.lGt.setClickable(false);
                return;
            }
            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.lGt.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnT() {
        this.lGt.setVisibility(4);
        this.lGv.setVisibility(4);
        this.lGu.setVisibility(0);
    }

    private JSONObject fF(String str, String str2) {
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

    private void e(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.lGt.setClickable(true);
        } else {
            b.dnl().a(null, str, hashMap, new d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.lGz.setCommitState(true);
                            FormCardView.this.dnT();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new com.baidu.tbadk.core.view.c().showFailToast(hVar.errorString);
                            FormCardView.this.lGz.setCommitState(false);
                        } else {
                            new com.baidu.tbadk.core.view.c().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.lGz.setCommitState(false);
                        }
                    }
                    FormCardView.this.lGt.setClickable(true);
                }
            });
        }
    }
}
