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
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class FormCardView extends BaseLegoCardView<FormCard> {
    private String aGv;
    private int kvA;
    private TitleView kvq;
    private CommitView kvr;
    private LinearLayout kvs;
    private LinearLayout kvt;
    private ImageView kvu;
    private TextView kvv;
    private TextView kvw;
    private FormCard kvx;
    private List<a> kvy;
    private float kvz;
    private Activity mActivity;
    private int mRealHeight;
    private View mRootView;
    private int mScreenWidth;
    private TbPageContext mTbPageContext;

    /* loaded from: classes13.dex */
    public interface a {
        boolean cNN();

        FormItemBaseView getFormView();

        String getResult();
    }

    public FormCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aGv = "";
        this.mScreenWidth = 0;
        this.mRealHeight = 0;
        this.kvz = 1.0f;
        this.kvA = -1;
        this.mTbPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        this.mScreenWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cna() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.card_form, (ViewGroup) null);
        this.kvq = (TitleView) this.mRootView.findViewById(R.id.form_title_view);
        this.kvu = (ImageView) this.mRootView.findViewById(R.id.tb_img_background);
        this.kvu.setEnabled(false);
        this.kvr = (CommitView) this.mRootView.findViewById(R.id.form_commit_view);
        this.kvt = (LinearLayout) this.mRootView.findViewById(R.id.item_content_view);
        this.kvs = (LinearLayout) this.mRootView.findViewById(R.id.form_commit_success_view);
        this.kvv = (TextView) this.mRootView.findViewById(R.id.form_success_title);
        this.kvw = (TextView) this.mRootView.findViewById(R.id.form_success_desc);
        initListener();
        return this.mRootView;
    }

    private void initListener() {
        if (this.kvr != null) {
            this.kvr.getCommitButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FormCardView.this.c(FormCardView.this.kvy, FormCardView.this.kvr.getPostUrl(), FormCardView.this.aGv);
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
        if (formCard != null && formCard.mIsLegal && this.kvx != formCard) {
            cNU();
            this.kvx = formCard;
            this.aGv = formCard.getItemId();
            cI(formCard.mWidth, formCard.mHeight);
            this.kvq.at(this.kvz);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kvq.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.kvz);
            }
            this.kvr.at(this.kvz);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kvr.getLayoutParams();
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size90)) * this.kvz);
            }
            this.kvq.a(formCard.titleInfo);
            this.kvr.a(formCard.commitInfo);
            b.cNp().a(new com.baidu.tieba.recapp.a.a(this.kvr.getPostUrl()));
            cNR();
            cNT();
            cNS();
            a(this.kvq);
            a(this.kvr);
            if (formCard.isCommitSuccess()) {
                cNV();
            }
            if (!formCard.mHasShown) {
                q.cNo().cNk().cU(formCard.getShowExtra(), this.mFrom);
                formCard.mHasShown = true;
            }
        }
    }

    private void cI(int i, int i2) {
        this.mRealHeight = (this.mScreenWidth * i2) / i;
        this.mRootView.getLayoutParams().height = this.mRealHeight;
        this.mRootView.getLayoutParams().width = this.mScreenWidth;
        this.kvz = (float) (this.mScreenWidth / 750.0d);
    }

    private void cNR() {
        this.mRootView.setBackgroundResource(R.drawable.form_defalut_bg_image);
        if (this.kvx.backgroundInfo != null) {
            this.kvu.setVisibility(0);
            if (!TextUtils.isEmpty(this.kvx.backgroundInfo.img)) {
                c.kV().a(this.kvx.backgroundInfo.img, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.2
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
                                        switch (FormCardView.this.kvx.backgroundInfo.mode) {
                                            case 1:
                                                FormCardView.this.kvu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.kvu.getLayoutParams().height = i2;
                                                break;
                                            case 2:
                                                FormCardView.this.kvu.getLayoutParams().width = FormCardView.this.mScreenWidth;
                                                FormCardView.this.kvu.getLayoutParams().height = FormCardView.this.mRealHeight;
                                                break;
                                        }
                                        int dA = com.baidu.tieba.lego.card.d.a.dA(FormCardView.this.kvx.backgroundInfo.color);
                                        if (!com.baidu.tieba.lego.card.d.a.xZ(dA)) {
                                            FormCardView.this.mRootView.setBackgroundColor(dA);
                                        }
                                        aVar.drawImageTo(FormCardView.this.kvu);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e) {
                                FormCardView.this.kvu.setImageBitmap(null);
                                FormCardView.this.kvu.setVisibility(8);
                                return;
                            } catch (OutOfMemoryError e2) {
                                FormCardView.this.kvu.setImageBitmap(null);
                                FormCardView.this.kvu.setVisibility(8);
                                return;
                            }
                        }
                        FormCardView.this.kvu.setVisibility(8);
                    }
                }, this.mTbPageContext.getUniqueId());
                return;
            }
        }
        this.kvu.setVisibility(8);
    }

    private void cNS() {
        FormCard.f fVar = this.kvx.resultInfo;
        float dimension = this.duG.getResources().getDimension(R.dimen.fontsize48);
        float dimension2 = this.duG.getResources().getDimension(R.dimen.fontsize28);
        int color = this.duG.getResources().getColor(R.color.form_font_color);
        if (fVar != null) {
            this.kvv.setText(fVar.title);
            this.kvv.setTextColor(-1);
            this.kvv.setTextSize(0, dimension);
            this.kvw.setText(fVar.desc);
            this.kvw.setTextColor(color);
            this.kvw.setTextSize(0, dimension2);
        }
    }

    private void cNT() {
        if (this.kvx.itemList != null && this.kvx.itemList.size() > 0) {
            int size = this.kvx.itemList.size();
            for (int i = 0; i < size; i++) {
                FormCard.b bVar = this.kvx.itemList.get(i);
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

    private void cNU() {
        this.kvt.removeAllViews();
        if (this.kvy != null) {
            this.kvy.clear();
        } else {
            this.kvy = new ArrayList();
        }
        this.kvr.setVisibility(0);
        this.kvt.setVisibility(0);
        this.kvs.setVisibility(8);
        this.kvr.setClickable(true);
        this.kvu.setImageBitmap(null);
    }

    private void a(FormCard.b bVar, FormItemBaseView formItemBaseView, int i, int i2) {
        formItemBaseView.at(this.kvz);
        formItemBaseView.a(bVar);
        a(formItemBaseView, i, i2);
        a(formItemBaseView);
        this.kvt.addView(formItemBaseView);
    }

    private void a(FormItemBaseView formItemBaseView, int i, int i2) {
        if (formItemBaseView != null) {
            if (i != i2 - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, formItemBaseView.cNW());
                layoutParams.bottomMargin = (int) (((int) this.mActivity.getApplicationContext().getResources().getDimension(R.dimen.form_size40)) * this.kvz);
                formItemBaseView.setLayoutParams(layoutParams);
                return;
            }
            formItemBaseView.setLayoutParams(new LinearLayout.LayoutParams(-1, formItemBaseView.cNW()));
        }
    }

    public void a(a aVar) {
        if (this.kvy == null) {
            this.kvy = new ArrayList();
        }
        this.kvy.add(aVar);
    }

    public void c(List<a> list, String str, String str2) {
        JSONObject eD;
        boolean z;
        if (list != null && list.size() >= 1) {
            boolean z2 = true;
            for (a aVar : list) {
                FormItemBaseView formView = aVar.getFormView();
                if (formView != null) {
                    if (!aVar.cNN()) {
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
                    if (formView2 != null && (eD = eD(formView2.getTag(), formView2.getResult())) != null) {
                        jSONArray.put(eD);
                    }
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("commit_content", jSONArray.toString());
                hashMap.put(LegoListActivityConfig.ITEM_ID, str2);
                hashMap.put("url", str);
                d(str, hashMap);
                this.kvr.setClickable(false);
                return;
            }
            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_error_string);
            this.kvr.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNV() {
        this.kvr.setVisibility(4);
        this.kvt.setVisibility(4);
        this.kvs.setVisibility(0);
    }

    private JSONObject eD(String str, String str2) {
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

    private void d(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            this.kvr.setClickable(true);
        } else {
            b.cNp().a(null, str, hashMap, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.recapp.lego.view.form.FormCardView.3
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (obj instanceof h) {
                        h hVar = (h) obj;
                        if (hVar.result) {
                            FormCardView.this.kvx.setCommitState(true);
                            FormCardView.this.cNV();
                        } else if (!TextUtils.isEmpty(hVar.errorString)) {
                            new d().showFailToast(hVar.errorString);
                            FormCardView.this.kvx.setCommitState(false);
                        } else {
                            new d().showToast(R.drawable.icon_toast_game_error, R.string.form_commit_fail_string);
                            FormCardView.this.kvx.setCommitState(false);
                        }
                    }
                    FormCardView.this.kvr.setClickable(true);
                }
            });
        }
    }
}
