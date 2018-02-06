package com.baidu.tieba.sharesdk.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
public class a {
    public static boolean h(Context context, Intent intent) {
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
