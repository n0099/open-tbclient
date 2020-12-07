package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    private boolean jbS;
    private TBSpecificationBtn kYU;
    private EditorTools kYV;
    private int kYW;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.kYW = 0;
        this.jbS = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.setMargins(0, l.getDimens(getContext(), R.dimen.ds30), 0, l.getDimens(getContext(), R.dimen.ds12));
        setLayoutParams(layoutParams);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.rd(R.color.CAM_X0110);
        bVar.rg(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.bc(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rf(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.kYU = new TBSpecificationBtn(getContext());
        this.kYU.setConfig(bVar);
        this.kYU.setTextSize(R.dimen.tbds32);
        this.kYU.setOnClickListener(this);
        this.kYU.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.kYU, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
    }

    public void changeSkinType(int i) {
        this.kYU.changeSkinType(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kYU) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 19) {
                if (aVar.data == null) {
                    hide();
                    return;
                }
                com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                if (aVar2.state == 1) {
                    this.kYU.setText(getContext().getString(R.string.location_loading));
                } else if (!TextUtils.isEmpty(aVar2.addr)) {
                    this.kYU.setText(aVar2.addr);
                } else {
                    this.kYU.setText(getContext().getString(R.string.location_where_are_you));
                }
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.kYV = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.kYV != null) {
            this.kYV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.kYW = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.kYW;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        if (this.jbS) {
            this.jbS = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        this.kYU.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        changeSkinType(i);
    }
}
