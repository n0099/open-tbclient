package com.baidu.tieba.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchBar extends LinearLayout {
    private Context a;
    private EditText b;
    private Button c;
    private Button d;
    private ci e;

    public SearchBar(Context context) {
        super(context);
        this.a = context;
        a();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        a();
    }

    public final void a(int i) {
        if (i == 1) {
            this.b.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text_1));
            setBackgroundColor(getResources().getColor(R.color.search_box_bg_1));
            return;
        }
        this.b.setHintTextColor(getResources().getColor(R.color.widget_searchbox_text));
        setBackgroundColor(getResources().getColor(R.color.search_box_bg));
    }

    private void a() {
        LayoutInflater.from(this.a).inflate(R.layout.search_bar, (ViewGroup) this, true);
        this.b = (EditText) findViewById(R.id.home_et_search);
        this.c = (Button) findViewById(R.id.home_bt_search_del);
        this.d = (Button) findViewById(R.id.home_bt_search_s);
        this.b.addTextChangedListener(new cf(this));
        this.c.setOnClickListener(new cg(this));
        this.d.setOnClickListener(new ch(this));
        a(TiebaApplication.g().ae());
    }

    public void setHint(String str) {
        this.b.setHint(str);
    }

    public void setHandler(ci ciVar) {
        this.e = ciVar;
    }

    public int getSearchButtonId() {
        return this.d.getId();
    }

    public EditText getEditText() {
        return this.b;
    }

    public void setSearchText(String str) {
        this.b.setText(str);
    }

    public String getSearchText() {
        Editable text = this.b.getText();
        return text != null ? text.toString() : "";
    }
}
