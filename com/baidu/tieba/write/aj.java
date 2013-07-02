package com.baidu.tieba.write;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.baidu.tieba.model.WriteModel;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aj implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r6 == r0) goto L28;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        GridView gridView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        EditText editText2;
        WriteModel writeModel;
        WriteModel writeModel2;
        EditText editText3;
        EditText editText4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        WriteModel writeModel3;
        EditText editText5;
        WriteModel writeModel4;
        ImageView imageView8;
        Button button;
        editText = this.a.e;
        if (view != editText) {
            imageView8 = this.a.g;
            if (view != imageView8) {
                button = this.a.j;
            }
        }
        if (z) {
            gridView = this.a.r;
            gridView.setVisibility(8);
            imageView = this.a.k;
            imageView.setClickable(false);
            imageView2 = this.a.l;
            imageView2.setClickable(false);
            imageView3 = this.a.m;
            imageView3.setClickable(false);
            imageView4 = this.a.k;
            imageView4.setImageDrawable(this.a.getResources().getDrawable(R.drawable.write_face));
        }
        editText2 = this.a.f;
        if (view == editText2) {
            if (!z) {
                writeModel = this.a.a;
                if (writeModel.getType() != 0) {
                    writeModel2 = this.a.a;
                    if (writeModel2.getType() == 3) {
                        editText3 = this.a.f;
                        editText3.setHint(R.string.lbs_post_content_hint);
                        return;
                    }
                    return;
                }
                editText4 = this.a.f;
                editText4.setHint(R.string.content);
                return;
            }
            imageView5 = this.a.k;
            imageView5.setClickable(true);
            imageView6 = this.a.l;
            imageView6.setClickable(true);
            imageView7 = this.a.m;
            imageView7.setClickable(true);
            writeModel3 = this.a.a;
            if (writeModel3.getType() != 0) {
                writeModel4 = this.a.a;
                if (writeModel4.getType() != 3) {
                    return;
                }
            }
            editText5 = this.a.f;
            editText5.setHint((CharSequence) null);
        }
    }
}
