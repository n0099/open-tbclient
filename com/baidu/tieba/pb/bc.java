package com.baidu.tieba.pb;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class bc implements View.OnClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        CharSequence text;
        if (view instanceof HeadImageView) {
            str = ((HeadImageView) view).getUserId();
            str2 = ((HeadImageView) view).getUserName();
        } else {
            String str3 = (String) view.getTag();
            if (!(view instanceof TextView) || (text = ((TextView) view).getText()) == null) {
                str = str3;
                str2 = null;
            } else {
                String charSequence = text.toString();
                int indexOf = charSequence.indexOf(91);
                if (indexOf < 1) {
                    indexOf = charSequence.indexOf(40);
                }
                if (indexOf > 0) {
                    String substring = charSequence.substring(0, indexOf);
                    str = str3;
                    str2 = substring;
                } else {
                    str = str3;
                    str2 = charSequence;
                }
            }
        }
        if (str != null) {
            PersonInfoActivity.a(this.a, str, str2);
        }
    }
}
