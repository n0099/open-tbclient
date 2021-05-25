package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class SimpleDragSortCursorAdapter extends ResourceDragSortCursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    public String[] f26188a;

    /* renamed from: b  reason: collision with root package name */
    public int f26189b;

    /* renamed from: c  reason: collision with root package name */
    public a f26190c;

    /* renamed from: d  reason: collision with root package name */
    public b f26191d;
    public int[] mFrom;
    public int[] mTo;

    /* loaded from: classes5.dex */
    public interface a {
        CharSequence a(Cursor cursor);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(View view, Cursor cursor, int i2);
    }

    @Deprecated
    public SimpleDragSortCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i2, cursor);
        this.f26189b = -1;
        this.mTo = iArr;
        this.f26188a = strArr;
        a(cursor, strArr);
    }

    private void a(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != length) {
                this.mFrom = new int[length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.mFrom[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
            }
            return;
        }
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        b bVar = this.f26191d;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i2 = 0; i2 < length; i2++) {
            View findViewById = view.findViewById(iArr[i2]);
            if (findViewById != null) {
                if (bVar != null ? bVar.a(findViewById, cursor, iArr2[i2]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i2]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.f26188a = strArr;
        this.mTo = iArr;
        a(cursor, strArr);
        super.changeCursor(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        a aVar = this.f26190c;
        if (aVar != null) {
            return aVar.a(cursor);
        }
        int i2 = this.f26189b;
        if (i2 > -1) {
            return cursor.getString(i2);
        }
        return super.convertToString(cursor);
    }

    public a getCursorToStringConverter() {
        return this.f26190c;
    }

    public int getStringConversionColumn() {
        return this.f26189b;
    }

    public b getViewBinder() {
        return this.f26191d;
    }

    public void setCursorToStringConverter(a aVar) {
        this.f26190c = aVar;
    }

    public void setStringConversionColumn(int i2) {
        this.f26189b = i2;
    }

    public void setViewBinder(b bVar) {
        this.f26191d = bVar;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        a(cursor, this.f26188a);
        return super.swapCursor(cursor);
    }

    public SimpleDragSortCursorAdapter(Context context, int i2, Cursor cursor, String[] strArr, int[] iArr, int i3) {
        super(context, i2, cursor, i3);
        this.f26189b = -1;
        this.mTo = iArr;
        this.f26188a = strArr;
        a(cursor, strArr);
    }
}
