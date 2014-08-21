package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ch;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FeedData;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d, m, com.baidu.tieba.util.n {
    private com.baidu.tbadk.core.view.v d;
    private com.baidu.tieba.model.ar g;
    private PbEditor i;
    private FeedData j;
    private FeedData k;
    private Handler l;
    private String m;
    private int n;
    private int o;
    private NavigationBar p;
    private String r;
    private LinearLayout s;
    private com.baidu.tbadk.core.view.d t;
    private com.baidu.tbadk.core.view.p u;
    private NoNetworkView v;
    private v b = null;
    private BdListView c = null;
    private Activity e = null;
    private at f = null;
    private View h = null;
    private WriteImagesInfo q = new WriteImagesInfo();
    private boolean w = false;
    private AlertDialog x = null;
    private final com.baidu.tieba.model.as y = new am(this);
    private av z = new an(this);
    private dj A = null;
    private final AbsListView.OnScrollListener B = new ao(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = layoutInflater.inflate(com.baidu.tieba.v.reply_me_activity, (ViewGroup) null);
        k();
        a(bundle);
        this.l = new Handler();
        return this.h;
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            WriteImagesInfo writeImagesInfo = (WriteImagesInfo) bundle.getSerializable("write_images");
            if (writeImagesInfo != null) {
                this.q = writeImagesInfo;
            }
            this.j = (FeedData) bundle.getSerializable("reply_thread");
            this.r = bundle.getString("photo_name");
        }
        this.q.setMaxImagesAllowed(10);
    }

    private void k() {
        this.d = new com.baidu.tbadk.core.view.v(getActivity());
        this.d.a(this);
        this.i = (PbEditor) this.h.findViewById(com.baidu.tieba.u.quick_reply_editor);
        this.i.a(true);
        this.i.setOnActionListener(new ap(this));
        this.s = (LinearLayout) this.h.findViewById(com.baidu.tieba.u.bodyNotLogin);
        this.u = new com.baidu.tbadk.core.view.p(this.h, com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1, com.baidu.tieba.u.no_data_container, com.baidu.tieba.u.no_data_image, com.baidu.tieba.u.no_data_image_text);
        this.c = (BdListView) this.h.findViewById(com.baidu.tieba.u.replyme_lv);
        this.c.setDividerHeight(0);
        this.c.setPullRefresh(this.d);
        this.c.setOnScrollListener(this.B);
        this.b = new v(this, 1, new aq(this));
        this.b.a(this.c);
        this.b.a((ViewGroup) this.h.findViewById(com.baidu.tieba.u.mention_layout_replyme1));
        this.b.a(this.u);
        this.b.a("c/u/feed/replyme");
        this.b.f();
        this.v = (NoNetworkView) this.h.findViewById(com.baidu.tieba.u.view_no_network_reply);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        int size;
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    c(intent);
                    int size2 = this.q.size() - 1;
                    if (size2 > -1 && this.q != null && this.q.getChosedFiles() != null && (size = this.q.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ch(this.e, 12012, this.q, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12004:
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.i.a(a);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a2 = this.g.a();
                    if (a2 != null) {
                        a2.deleteUploadedTempImages();
                    }
                    this.g.a((WriteData) null);
                    this.g.a(false);
                    d(true);
                    c(true);
                    a(this.q, true);
                    this.b.i();
                    i();
                    return;
                case 12012:
                    b(intent);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    a();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.q.setLastAlbumId(intent.getStringExtra("last_album_id"));
                        return;
                    }
                    return;
                case 12003:
                default:
                    return;
            }
        }
    }

    public void a(Intent intent) {
        a(intent, true);
    }

    public void b(Intent intent) {
        a(intent, false);
    }

    public void a() {
        new ar(this).execute(new Void[0]);
    }

    private void c(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.r;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.d.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this.e, com.baidu.adp.lib.util.j.b(this.e)), com.baidu.adp.lib.util.j.a(this.e, com.baidu.adp.lib.util.j.c(this.e)));
                    Bitmap e = com.baidu.tbadk.core.util.d.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.r, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.q.addChooseFile(imageFileInfo);
            this.q.updateQuality();
            a(this.q, true);
        }
        if (this.q.getChosedFiles() != null && this.q.getChosedFiles().size() > 0) {
            this.i.b(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.q.parseJson(stringExtra);
                this.q.updateQuality();
                if (this.q.getChosedFiles() != null) {
                    a(this.q, z);
                }
            }
            if (this.q.getChosedFiles() != null && this.q.getChosedFiles().size() > 0) {
                this.i.b(23);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            this.u.a(i);
            if (this.d != null) {
                this.d.a(i);
            }
            if (this.t != null) {
                this.t.b(i);
            }
            if (this.b != null) {
                this.b.i();
            }
            if (this.v != null) {
                this.v.a(i);
            }
            if (this.i != null) {
                this.i.c(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.c.setVisibility(0);
            this.s.setVisibility(8);
            if (this.w) {
                this.w = false;
                f();
            }
            this.b.h();
        } else {
            this.u.b(8);
            l();
        }
        c(TbadkApplication.m252getInst().getSkinType());
    }

    public void f() {
        if (this.b == null) {
            this.w = true;
            return;
        }
        this.w = false;
        if (TbadkApplication.isLogin()) {
            this.c.setVisibility(0);
            this.s.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().m() > 0) {
                this.b.a(2);
            } else {
                this.b.a(1);
            }
            this.b.g();
            this.b.h();
            return;
        }
        l();
    }

    private void l() {
        if (this.t == null) {
            this.t = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.x.login_msg_tab), getString(com.baidu.tieba.x.login_msg_form), 3);
            this.s.addView(this.t.b());
            this.t.b(TbadkApplication.m252getInst().getSkinType());
        } else {
            ((ViewGroup) this.t.b().getParent()).removeAllViews();
            this.s.addView(this.t.b());
            this.t.b(TbadkApplication.m252getInst().getSkinType());
        }
        this.c.setVisibility(8);
        this.s.setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.u.b();
        if (this.t != null) {
            this.t.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.u.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.g != null) {
            this.g.cancelLoadData();
        }
        try {
            if (this.b != null) {
                this.b.c();
                this.b.a();
            }
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }

    public void g() {
        this.b.d();
    }

    public void a(com.baidu.tieba.model.al alVar) {
        this.b.a(alVar);
    }

    public int h() {
        return this.b.e();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            g();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("write_images", this.q);
        bundle.putString("photo_name", this.r);
        bundle.putSerializable("reply_thread", this.j);
    }

    public void a(NavigationBar navigationBar) {
        this.p = navigationBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.x == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.e);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new as(this));
            this.x = builder.create();
            this.x.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            antiData.setBlock_forum_name(this.j.getFname());
            antiData.setBlock_forum_id(this.m);
            antiData.setUser_name(this.j.getReplyer().getUserName());
            antiData.setUser_id(this.j.getReplyer().getUserId());
            AntiHelper.a(this.e, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.j.a((Context) this.e, str);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.e = activity;
        this.f = new at(activity, this);
        this.f.a(this.z);
        this.g = new com.baidu.tieba.model.ar();
        this.g.a(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.g.a() == null) {
            WriteData o = o();
            o.setWriteImagesInfo(this.q);
            this.g.a(this.q.size() > 0);
            this.g.a(o);
        }
        if (this.g.a() != null) {
            this.g.a().setIsFrsReply(true);
            this.g.a().setContent(this.i.getContent());
            VoiceData.VoiceModel audioData = this.i.getAudioData();
            this.i.s();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.g.a().setVoice(audioData.getId());
                    this.g.a().setVoiceDuringTime(audioData.duration);
                } else {
                    this.g.a().setVoice(null);
                    this.g.a().setVoiceDuringTime(-1);
                }
            } else {
                this.g.a().setVoice(null);
                this.g.a().setVoiceDuringTime(-1);
            }
            if (!this.g.b()) {
            }
        }
    }

    private WriteData o() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.m);
        writeData.setForumName(this.j.getFname());
        writeData.setThreadId(this.j.getThread_id());
        writeData.setIsAd(false);
        writeData.setFloorNum(0);
        if (this.j.getIsFloor()) {
            writeData.setFloor(this.j.getQuote_pid());
        } else {
            writeData.setFloor(this.j.getPost_id());
        }
        writeData.setType(2);
        return writeData;
    }

    @Override // com.baidu.tieba.mention.m
    public void a(int i, View view, View view2, FeedData feedData) {
        long a;
        if (view != null && this.f != null && view2 != null && feedData != null && view.getId() == com.baidu.tieba.u.ll_quick_reply) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
            this.o = rect.bottom;
            this.n = i;
            this.k = feedData;
            if (feedData.getIsFloor()) {
                a = com.baidu.adp.lib.e.c.a(feedData.getQuote_pid(), 0L);
            } else {
                a = com.baidu.adp.lib.e.c.a(feedData.getPost_id(), 0L);
            }
            this.f.a(a, 2, feedData.getFname());
        }
    }

    public void c(boolean z) {
        if (this.j != null) {
            if (z) {
                if (this.j.getIsFloor() && this.j.getReplyer() != null) {
                    com.baidu.tieba.util.m.b(this.j.getReplyer().getUserId(), (WriteData) null);
                } else {
                    com.baidu.tieba.util.m.b(this.j.getThread_id(), (WriteData) null);
                }
            } else if (this.g != null && this.i != null) {
                WriteData a = this.g.a();
                if (a == null) {
                    a = new WriteData(2);
                    a.setThreadId(this.j.getThread_id());
                    a.setWriteImagesInfo(this.q);
                }
                a.setContent(this.i.getContent());
                if (this.j.getIsFloor() && this.j.getReplyer() != null) {
                    com.baidu.tieba.util.m.b(this.j.getReplyer().getUserId(), a);
                } else {
                    com.baidu.tieba.util.m.b(this.j.getThread_id(), a);
                }
            }
        }
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (this.j != null) {
            if (writeData == null || ((writeData.getThreadId() != null && !writeData.getThreadId().equals(this.j.getThread_id())) || ba.c(writeData.getContent()))) {
                if (isAdded() && this.j.getIsFloor() && this.j.getReplyer() != null) {
                    this.i.setContent(String.valueOf(getString(com.baidu.tieba.x.mention_replyme)) + this.j.getReplyer().getName_show() + ":");
                    return;
                } else {
                    this.i.setContent(null);
                    return;
                }
            }
            String content = writeData.getContent();
            if (isAdded() && this.j.getIsFloor() && this.j.getReplyer() != null) {
                if (content.startsWith(String.valueOf(getString(com.baidu.tieba.x.mention_replyme)) + this.j.getReplyer().getName_show() + ":")) {
                    this.i.setContent(content);
                } else {
                    this.i.setContent(String.valueOf(getString(com.baidu.tieba.x.mention_replyme)) + this.j.getReplyer().getName_show() + ":");
                }
            } else if (isAdded() && !content.startsWith(String.valueOf(getString(com.baidu.tieba.x.mention_replyme)) + this.j.getReplyer().getName_show() + ":")) {
                this.i.setContent(content);
            } else {
                this.i.setContent(null);
            }
            if (writeData.getWriteImagesInfo() != null && this.q.size() == 0) {
                this.q.copyFrom(writeData.getWriteImagesInfo());
                a(this.q, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (z) {
            this.i.getEditText().setText("");
            this.i.b();
            this.i.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.i.c.a(writeImagesInfo, z);
    }

    public void i() {
        c(false);
        this.i.b(this.i.getEditText());
        this.i.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedData feedData) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a(this.e, this.e.getString(com.baidu.tieba.x.login_to_use), true, 0);
            return;
        }
        if (feedData != null && this.i != null) {
            if (feedData.getIsFloor() && feedData.getReplyer() != null) {
                com.baidu.tieba.util.m.a(feedData.getReplyer().getUserId(), this);
            } else {
                com.baidu.tieba.util.m.a(feedData.getThread_id(), this);
            }
            this.q = new WriteImagesInfo();
            this.q.setMaxImagesAllowed(10);
            a(this.q, true);
            this.g.a((WriteData) null);
            this.g.a(false);
            this.i.t();
        }
        this.j = feedData;
        p();
    }

    private void p() {
        this.i.n();
        this.i.u();
        if (this.i.h()) {
            this.i.k();
        } else {
            this.i.getEditText().requestFocus();
            this.i.a(this.i.getEditText());
        }
        a(this.n, this.o);
    }

    protected void a(int i, int i2) {
        int i3 = 0;
        if (this.p != null) {
            i3 = this.p.getHeight() + 0 + com.baidu.adp.lib.util.j.a((Context) this.e, 40.0f);
        }
        this.A = new dj(this.e, i, i2, this.i, this.c, i3);
        this.l.postDelayed(this.A, 300L);
    }

    public PbEditor j() {
        return this.i;
    }
}
