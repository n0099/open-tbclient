package com.baidu.tieba.tbadkCore.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ai;
import com.baidu.adp.widget.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j implements ai, as {
    public static final BdUniqueId cog = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String coi;
    private ArrayList<j> cok;
    private ArrayList<j> con;
    private int cop;
    private com.baidu.tbadk.data.a coq;
    private com.baidu.tbadk.data.d cor;
    private HashMap<String, MetaData> userMap;
    private boolean col = false;
    private com.baidu.tbadk.widget.richText.a coo = null;
    private String id = null;
    private String title = null;
    private int coh = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<c> bux = new ArrayList<>();
    private ArrayList<c> bvf = new ArrayList<>();
    private int coj = 0;

    /* renamed from: com  reason: collision with root package name */
    private int f127com = 0;

    public j() {
        this.cok = null;
        this.con = null;
        this.cok = new ArrayList<>();
        this.con = new ArrayList<>();
    }

    public ArrayList<j> amM() {
        return this.cok;
    }

    public void amN() {
        this.coj--;
    }

    public void it(int i) {
        this.coj = i;
    }

    public ArrayList<j> amO() {
        return this.con;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int amP() {
        return this.coh;
    }

    public void iu(int i) {
        this.coh = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void a(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a amQ() {
        return this.coo;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a amR() {
        return this.coq;
    }

    public com.baidu.tbadk.data.d amS() {
        return this.cor;
    }

    public void b(TbPageContext<?> tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        if (tbPageContext != null && this.coo != null && this.coo.DB() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(t.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    p pVar = new p(new k(this, it.next(), tbPageContext), 0, 1);
                    pVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.small_icon_height));
                    arrayList.add(pVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            m mVar = new m(this, tbPageContext.getPageActivity(), str, str2);
            if (z) {
                TbadkCoreApplication.m411getInst().getSkinType();
                Bitmap cg = ba.cg(u.icon_floorhost);
                if (cg != null) {
                    int width = (cg.getWidth() * dimensionPixelSize) / cg.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cg);
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.author != null) {
                        spannableString.setSpan(imageSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, sb2.length(), str3.length() + sb2.length(), 17);
                    }
                }
            }
            spannableString.setSpan(mVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> DB = this.coo.DB();
            if (DB != null && DB.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = DB.get(0);
                if (cVar.DH() != null) {
                    cVar.eh(sb.length());
                    cVar.DH().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.eh(sb.length());
                cVar2.append(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < DB.size()) {
                        if (DB.get(i4).getType() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(DB.get(i4).DI());
                            DB.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                DB.add(0, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap mz;
        if (aVar == null || (mz = aVar.mz()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mz);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.small_icon_height));
        return bitmapDrawable;
    }

    public int amT() {
        return this.coj;
    }

    public int amU() {
        return this.f127com;
    }

    public void aD(Context context) {
        int type;
        int i;
        int i2;
        if (this.bux != null) {
            int i3 = -1;
            int size = this.bvf.size();
            if (size > 0) {
                try {
                    i3 = this.bvf.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bux.size()) {
                c cVar = this.bux.get(i4);
                if (c.ah(i5, cVar.getType())) {
                    this.bvf.get(size - 1).a(cVar.aC(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (cVar.getType() == 3 || cVar.getType() == 2 || cVar.getType() == 11) {
                        this.bvf.add(cVar);
                        type = cVar.getType();
                    } else {
                        c cVar2 = new c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aC(context));
                        this.bvf.add(cVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void aE(Context context) {
        try {
            if (this.coo != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.coo.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bvf == null || this.bvf.size() == 0) {
                aD(context);
            }
            ArrayList<c> arrayList = this.bvf;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.getType() == 0) {
                        if (next.amy() != null) {
                            sb.append((CharSequence) next.amy());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(y.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(y.voice_str));
                    } else if (next.getType() == 2) {
                        String ef = TbFaceManager.zx().ef(next.getText());
                        if (ef != null) {
                            sb.append("[");
                            sb.append(ef);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !bd.isEmpty(next.amx())) {
                        sb.append("[").append(next.amx()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.coh = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL) && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals(GameInfoData.NOT_FROM_DETAIL)) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.coo = TbRichTextView.a(context, subPostList.content, z);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.coh = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.coi = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.coj = post.sub_post_number.intValue();
                this.f127com = post.add_post_number.intValue();
                this.coo = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            j jVar = new j();
                            jVar.setUserMap(this.userMap);
                            jVar.a(list.get(i), context);
                            this.cok.add(jVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList : list2) {
                            j jVar2 = new j();
                            jVar2.setUserMap(this.userMap);
                            jVar2.a(subPostList, context);
                            this.con.add(jVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.con.size() >= 5) {
                    this.cop = 5;
                } else {
                    this.cop = this.con.size();
                }
                if (post.tail_info != null) {
                    this.coq = new com.baidu.tbadk.data.a();
                    this.coq.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cor = new com.baidu.tbadk.data.d();
                    this.cor.a(post.lbs_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String aF(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> DB;
        if (this.coo == null || (DB = this.coo.DB()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = DB.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.DH().toString());
            } else if (next.getType() == 17) {
                String str = next.DK().akS.aks;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(y.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(y.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(y.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int amV() {
        return this.cop;
    }

    public void iv(int i) {
        this.cop = i;
    }

    public ar amW() {
        ArrayList<com.baidu.tbadk.widget.richText.c> DB;
        if (this.coo != null && (DB = this.coo.DB()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = DB.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ar arVar = new ar();
                    arVar.width = next.DG().getWidth();
                    arVar.height = next.DG().getHeight();
                    arVar.QM = next.DG().DO();
                    arVar.UW = 17;
                    return arVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.as
    public ArrayList<ar> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> DB;
        if (this.coo == null || (DB = this.coo.DB()) == null) {
            return null;
        }
        ArrayList<ar> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = DB.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ar arVar = new ar();
                arVar.width = next.DG().getWidth();
                arVar.height = next.DG().getHeight();
                arVar.QM = next.DG().DO();
                arVar.UW = 17;
                arrayList.add(arVar);
            } else if (next.DK() != null) {
                ar arVar2 = new ar();
                arVar2.width = next.DK().akS.akw;
                arVar2.height = next.DK().akS.akx;
                arVar2.UX = next.DK();
                arVar2.UW = 20;
                arrayList.add(arVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cop) {
                break;
            }
            arrayList.addAll(this.con.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ar arVar3 = new ar();
            arVar3.QM = this.bimg_url;
            arVar3.width = 105;
            arVar3.width = 105;
            arVar3.UW = 19;
            arrayList.add(arVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ar arVar4 = new ar();
        arVar4.QM = this.author.getPortrait();
        arVar4.UW = 12;
        arrayList.add(arVar4);
        if (this.con != null) {
            Iterator<j> it2 = this.con.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return cog;
    }

    public boolean amX() {
        return this.col;
    }

    public void eN(boolean z) {
        this.col = z;
    }
}
