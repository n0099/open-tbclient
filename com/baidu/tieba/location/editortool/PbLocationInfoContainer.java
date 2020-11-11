package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    private boolean iQn;
    private TBSpecificationBtn kLo;
    private EditorTools kLp;
    private int kLq;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.kLq = 0;
        this.iQn = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(l.getDimens(getContext(), R.dimen.ds20), 0, l.getDimens(getContext(), R.dimen.ds20), 0);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.setMargins(0, l.getDimens(getContext(), R.dimen.ds30), 0, l.getDimens(getContext(), R.dimen.ds12));
        setLayoutParams(layoutParams);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qk(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.qe(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.kLo = new TBSpecificationBtn(getContext());
        this.kLo.setConfig(bVar);
        this.kLo.setTextSize(R.dimen.tbds32);
        this.kLo.setOnClickListener(this);
        this.kLo.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.kLo, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
    }

    public void changeSkinType(int i) {
        this.kLo.changeSkinType(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kLo) {
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
                    this.kLo.setText(getContext().getString(R.string.location_loading));
                } else if (!TextUtils.isEmpty(aVar2.addr)) {
                    this.kLo.setText(aVar2.addr);
                } else {
                    this.kLo.setText(getContext().getString(R.string.location_where_are_you));
                }
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.kLp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.kLp != null) {
            this.kLp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.kLq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.kLq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iQn) {
            this.iQn = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        this.kLo.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        changeSkinType(i);
    }
}
