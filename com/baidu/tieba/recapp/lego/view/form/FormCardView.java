package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.view.d;
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
/* loaded from: classes13.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aod;
    private TitleView jMa;
    private CommitView jMb;
    private LinearLayout jMc;
    private LinearLayout jMd;
    private ImageView jMe;
    private TextView jMf;
    private TextView jMg;
    private FormCard jMh;
    private List<a> jMi;
    private float jMj;
    private int jMk;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes13.dex */
    public interface a {
        boolean cDs();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aod = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.jMj = 1.0f;
        this.jMk = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccz() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.jMa = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.jMe = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.jMe.setEnabled(false);
        this.jMb = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.jMd = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.jMc = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.jMf = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.jMg = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.jMb != null) {
            this.jMb.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.jMi, FormCardView.this.jMb.getPostUrl(), FormCardView.this.aod);
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
        if (formCard != null && formCard.mIsLegal && this.jMh != formCard) {
            cDz();
            this.jMh = formCard;
            this.aod = formCard.getItemId();
            cC(formCard.mWidth, formCard.mHeight);
            this.jMa.aJ(this.jMj);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jMa.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jMj);
            }
            this.jMb.aJ(this.jMj);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jMb.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.jMj);
            }
            this.jMa.a(formCard.titleInfo);
            this.jMb.a(formCard.commitInfo);
            b.cCR().a(new com.baidu.tieba.recapp.a.a(this.jMb.getPostUrl()));
            cDw();
            cDy();
            cDx();
            a(this.jMa);
            a(this.jMb);
            if (formCard.isCommitSuccess()) {
                cDA();
            }
            if (!formCard.mHasShown) {
                r.cCQ().cCM().cJ(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cC(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.jMj = (float) (this.mScreenWidth / 750.0d);
    }

    private void cDw() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.jMh.backgroundInfo != null) {
            this.jMe.setVisibility(0);
            if (!TextUtils.isEmpty(this.jMh.backgroundInfo.img)) {
                c.gr().a(this.jMh.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.jMh.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.jMe.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jMe.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.jMe.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.jMe.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int cF = com.baidu.tieba.lego.card.d.a.cF(FormCardView.this.jMh.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.xz(cF)) {
                                            FormCardView.this.mRootView.setBackgroundColor(cF);
                                        }
                                        aVar.drawImageTo(FormCardView.this.jMe);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.jMe.setImageBitmap(null);
                                FormCardView.this.jMe.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.jMe.setImageBitmap(null);
                                FormCardView.this.jMe.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.jMe.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.jMe.setVisibility(8);
    }

    private void cDx() {
        FormCard.f fVar = this.jMh.resultInfo;
        float dimension = this.cVv.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.cVv.getResources().getDimension(R.dimen.fontsize28);
        int color = this.cVv.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.jMf.setText(fVar.title);
            this.jMf.setTextColor(-1);
            this.jMf.setTextSize(0, dimension);
            this.jMg.setText(fVar.desc);
            this.jMg.setTextColor(color);
            this.jMg.setTextSize(0, dimension2);
        }
    }

    private void cDy() {
        if (this.jMh.itemList != null && this.jMh.itemList.size() > 0) {
            int size = this.jMh.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.jMh.itemList.get(i);
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

    private void cDz() {
        this.jMd.removeAllViews();
        if (this.jMi != null) {
            this.jMi.clear();
        } else {
            this.jMi = new ArrayList();
        }
        this.jMb.setVisibility(0);
        this.jMd.setVisibility(0);
        this.jMc.setVisibility(8);
        this.jMb.setClickable(true);
        this.jMe.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.aJ(this.jMj);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.jMd.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cDB());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.jMj);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cDB()));
        }
    }

    public void a(a aVar) {
        if (this.jMi == null) {
            this.jMi = new ArrayList();
        }
        this.jMi.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject eo;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cDs()) {
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
                    if (formView2 != null && (eo = eo(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(eo);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                e(str, hashMap);
                this.jMb.setClickable(false);
                return;
            }
            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.jMb.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDA() {
        this.jMb.setVisibility(4);
        this.jMd.setVisibility(4);
        this.jMc.setVisibility(0);
    }

    private JSONObject eo(String str, String str2) {
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
            this.jMb.setClickable(true);
        } else {
            b.cCR().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.jMh.setCommitState(true);
                            FormCardView.this.cDA();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().showFailToast(hVar.errorString);
                            FormCardView.this.jMh.setCommitState(false);
                        } else {
                            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.jMh.setCommitState(false);
                        }
                    }
                    FormCardView.this.jMb.setClickable(true);
                }
            });
        }
    }
}
