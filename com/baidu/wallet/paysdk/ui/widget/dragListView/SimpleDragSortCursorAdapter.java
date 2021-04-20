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
    public String[] f26204a;

    /* renamed from: b  reason: collision with root package name */
    public int f26205b;

    /* renamed from: c  reason: collision with root package name */
    public a f26206c;

    /* renamed from: d  reason: collision with root package name */
    public b f26207d;
    public int[] mFrom;
    public int[] mTo;

    /* loaded from: classes5.dex */
    public interface a {
        CharSequence a(Cursor cursor);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleDragSortCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.f26205b = -1;
        this.mTo = iArr;
        this.f26204a = strArr;
        a(cursor, strArr);
    }

    private void a(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.mFrom[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        b bVar = this.f26207d;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (bVar != null ? bVar.a(findViewById, cursor, iArr2[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i]);
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
        this.f26204a = strArr;
        this.mTo = iArr;
        a(cursor, strArr);
        super.changeCursor(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        a aVar = this.f26206c;
        if (aVar != null) {
            return aVar.a(cursor);
        }
        int i = this.f26205b;
        if (i > -1) {
            return cursor.getString(i);
        }
        return super.convertToString(cursor);
    }

    public a getCursorToStringConverter() {
        return this.f26206c;
    }

    public int getStringConversionColumn() {
        return this.f26205b;
    }

    public b getViewBinder() {
        return this.f26207d;
    }

    public void setCursorToStringConverter(a aVar) {
        this.f26206c = aVar;
    }

    public void setStringConversionColumn(int i) {
        this.f26205b = i;
    }

    public void setViewBinder(b bVar) {
        this.f26207d = bVar;
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
        a(cursor, this.f26204a);
        return super.swapCursor(cursor);
    }

    public SimpleDragSortCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.f26205b = -1;
        this.mTo = iArr;
        this.f26204a = strArr;
        a(cursor, strArr);
    }
}
