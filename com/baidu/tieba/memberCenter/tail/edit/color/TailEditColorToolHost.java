package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {
    private EditorTools acX;
    private int acY;
    private View.OnClickListener fjU;
    private c lkk;
    private a lkn;
    private e lko;

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.acY = 0;
        this.fjU = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.color.TailEditColorToolHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    TailEditColorToolHost.this.lkk.tk(bVar.getColor());
                    TailEditColorToolHost.this.lkn.notifyDataSetChanged();
                    TailEditColorToolHost.this.acX.b(new com.baidu.tbadk.editortools.a(26, -1, bVar.getColor()));
                }
            }
        };
        e(tbPageContext, str);
    }

    private void e(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.lko = new e(this);
        this.lkk = new c(tbPageContext);
        this.lkk.tk(str);
        this.lkn = new a(tbPageContext, this.lkk, this.fjU);
        this.lko.a(this.lkn);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
