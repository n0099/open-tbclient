package com.baidu.zeus;

import android.content.Context;
import android.content.res.Resources;
import java.util.Calendar;
/* loaded from: classes.dex */
public class DateSorter {
    public static final int DAY_COUNT = 5;
    private static final String LOGTAG = "webkit";
    private static final int NUM_DAYS_AGO = 7;
    private long[] mBins = new long[4];
    private String[] mLabels = new String[5];

    public DateSorter(Context context) {
        Resources resources = context.getResources();
        Calendar calendar = Calendar.getInstance();
        beginningOfDay(calendar);
        this.mBins[0] = calendar.getTimeInMillis();
        calendar.add(6, -1);
        this.mBins[1] = calendar.getTimeInMillis();
        calendar.add(6, -6);
        this.mBins[2] = calendar.getTimeInMillis();
        calendar.add(6, 7);
        calendar.add(2, -1);
        this.mBins[3] = calendar.getTimeInMillis();
        this.mLabels[0] = context.getText(17039462).toString();
        this.mLabels[1] = context.getText(17039461).toString();
        this.mLabels[2] = String.format(resources.getQuantityString(17760259, 7), 7);
        this.mLabels[3] = context.getText(context.getResources().getIdentifier("zeus_one_month_duration_past", "string", context.getPackageName())).toString();
        this.mLabels[4] = context.getText(context.getResources().getIdentifier("zeus_before_one_month_duration_past", "string", context.getPackageName())).toString();
    }

    public int getIndex(long j) {
        for (int i = 0; i < 4; i++) {
            if (j > this.mBins[i]) {
                return i;
            }
        }
        return 4;
    }

    public String getLabel(int i) {
        return (i < 0 || i >= 5) ? "" : this.mLabels[i];
    }

    public long getBoundary(int i) {
        i = (i < 0 || i > 4) ? 0 : 0;
        if (i == 4) {
            return Long.MIN_VALUE;
        }
        return this.mBins[i];
    }

    private void beginningOfDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }
}
