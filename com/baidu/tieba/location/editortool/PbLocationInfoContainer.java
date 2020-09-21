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
/* loaded from: classes22.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    private boolean iiX;
    private TBSpecificationBtn kdH;
    private EditorTools kdI;
    private int kdJ;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.kdJ = 0;
        this.iiX = true;
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
        bVar.pr(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pk(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.kdH = new TBSpecificationBtn(getContext());
        this.kdH.setConfig(bVar);
        this.kdH.setTextSize(R.dimen.tbds32);
        this.kdH.setOnClickListener(this);
        this.kdH.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.kdH, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
    }

    public void changeSkinType(int i) {
        this.kdH.changeSkinType(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kdH) {
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
                    this.kdH.setText(getContext().getString(R.string.location_loading));
                } else if (!TextUtils.isEmpty(aVar2.addr)) {
                    this.kdH.setText(aVar2.addr);
                } else {
                    this.kdH.setText(getContext().getString(R.string.location_where_are_you));
                }
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.kdI = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.kdI != null) {
            this.kdI.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.kdJ = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.kdJ;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iiX) {
            this.iiX = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        this.kdH.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        changeSkinType(i);
    }
}
