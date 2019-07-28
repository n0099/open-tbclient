package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> fcJ;
    private a hWG;
    private EmotionView.a hWH;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.fcJ)) {
            return 0;
        }
        return this.fcJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fcJ = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0382b c0382b;
        if (view == null) {
            C0382b c0382b2 = new C0382b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0382b2.hBY = (EmotionView) view.findViewById(R.id.emotion_view);
            c0382b2.hBY.bhi();
            c0382b2.hBY.setController(this.hWH);
            c0382b2.hBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hWG != null && (view2 instanceof EmotionView)) {
                        b.this.hWG.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0382b2);
            c0382b = c0382b2;
        } else {
            c0382b = (C0382b) view.getTag();
        }
        if (this.fcJ != null && i >= 0 && i < this.fcJ.size()) {
            c0382b.hBY.a(this.fcJ.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hWG = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hWH = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0382b {
        EmotionView hBY;

        C0382b() {
        }
    }
}
