package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ai;
import com.baidu.adp.widget.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.q;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.u;
import com.baidu.tieba.o;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j implements ai, ap {
    public static final BdUniqueId cse = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String csg;
    private ArrayList<j> csi;
    private ArrayList<j> csl;
    private int csn;
    private com.baidu.tbadk.data.a cso;
    private com.baidu.tbadk.data.d csp;
    private HashMap<String, MetaData> userMap;
    private boolean csj = false;
    private com.baidu.tbadk.widget.richText.a csm = null;
    private String id = null;
    private String title = null;
    private int csf = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<c> bxf = new ArrayList<>();
    private ArrayList<c> bxN = new ArrayList<>();
    private int csh = 0;
    private int csk = 0;

    public j() {
        this.csi = null;
        this.csl = null;
        this.csi = new ArrayList<>();
        this.csl = new ArrayList<>();
    }

    public ArrayList<j> aoy() {
        return this.csi;
    }

    public void aoz() {
        this.csh--;
    }

    public void iP(int i) {
        this.csh = i;
    }

    public ArrayList<j> aoA() {
        return this.csl;
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

    public int aoB() {
        return this.csf;
    }

    public void iQ(int i) {
        this.csf = i;
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

    public com.baidu.tbadk.widget.richText.a aoC() {
        return this.csm;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aoD() {
        return this.cso;
    }

    public com.baidu.tbadk.data.d aoE() {
        return this.csp;
    }

    public void b(TbPageContext<?> tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        u uVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap ck;
        if (tbPageContext != null && this.csm != null && this.csm.El() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(o.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    p pVar = new p(new k(this, it.next(), tbPageContext), 0, 1);
                    pVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(o.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(o.small_icon_height));
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
            m mVar = new m(this, TbadkCoreApplication.m411getInst().getApp(), str, str2);
            if (z && (ck = ay.ck(com.baidu.tieba.p.icon_floorhost)) != null) {
                int width = (ck.getWidth() * dimensionPixelSize) / ck.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ck);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                q qVar = new q(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(qVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(qVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(mVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> El = this.csm.El();
            if (El != null && El.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = El.get(0);
                if (cVar2.Er() != null) {
                    cVar2.et(sb.length());
                    cVar2.Er().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= El.size()) {
                        uVar = null;
                        break;
                    } else if (El.get(i4) == null || El.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        u Es = El.get(i4).Es();
                        El.remove(i4);
                        uVar = Es;
                        break;
                    }
                }
                if (uVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(uVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.et(sb.length());
                cVar.append(spannableString);
                El.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap mS;
        if (aVar == null || (mS = aVar.mS()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mS);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(o.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(o.small_icon_height));
        return bitmapDrawable;
    }

    public int aoF() {
        return this.csh;
    }

    public int aoG() {
        return this.csk;
    }

    public void aI(Context context) {
        int type;
        int i;
        int i2;
        if (this.bxf != null) {
            int i3 = -1;
            int size = this.bxN.size();
            if (size > 0) {
                try {
                    i3 = this.bxN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.bxf.size()) {
                c cVar = this.bxf.get(i4);
                if (c.ai(i5, cVar.getType())) {
                    this.bxN.get(size - 1).a(cVar.aH(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (cVar.getType() == 3 || cVar.getType() == 2 || cVar.getType() == 11) {
                        this.bxN.add(cVar);
                        type = cVar.getType();
                    } else {
                        c cVar2 = new c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aH(context));
                        this.bxN.add(cVar2);
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

    public void aJ(Context context) {
        try {
            if (this.csm != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.csm.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bxN == null || this.bxN.size() == 0) {
                aI(context);
            }
            ArrayList<c> arrayList = this.bxN;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.getType() == 0) {
                        if (next.aok() != null) {
                            sb.append((CharSequence) next.aok());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(t.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(t.voice_str));
                    } else if (next.getType() == 2) {
                        String ew = TbFaceManager.Ak().ew(next.getText());
                        if (ew != null) {
                            sb.append("[");
                            sb.append(ew);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !bb.isEmpty(next.aoj())) {
                        sb.append("[").append(next.aoj()).append("]");
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
                this.csf = subPostList.floor.intValue();
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
                this.csm = TbRichTextView.a(context, subPostList.content, z);
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
                this.csf = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.csg = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.csh = post.sub_post_number.intValue();
                this.csk = post.add_post_number.intValue();
                this.csm = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            j jVar = new j();
                            jVar.setUserMap(this.userMap);
                            jVar.a(list.get(i), context);
                            this.csi.add(jVar);
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
                            this.csl.add(jVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.csl.size() >= 5) {
                    this.csn = 5;
                } else {
                    this.csn = this.csl.size();
                }
                if (post.tail_info != null) {
                    this.cso = new com.baidu.tbadk.data.a();
                    this.cso.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.csp = new com.baidu.tbadk.data.d();
                    this.csp.a(post.lbs_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String aK(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> El;
        if (this.csm == null || (El = this.csm.El()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = El.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Er().toString());
            } else if (next.getType() == 17) {
                String str = next.Eu().alT.alt;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(t.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(t.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(t.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aoH() {
        return this.csn;
    }

    public void iR(int i) {
        this.csn = i;
    }

    public ao aoI() {
        ArrayList<com.baidu.tbadk.widget.richText.c> El;
        if (this.csm != null && (El = this.csm.El()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = El.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ao aoVar = new ao();
                    aoVar.width = next.Eq().getWidth();
                    aoVar.height = next.Eq().getHeight();
                    aoVar.Ri = next.Eq().Ey();
                    aoVar.Vx = 17;
                    return aoVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ap
    public ArrayList<ao> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> El;
        if (this.csm == null || (El = this.csm.El()) == null) {
            return null;
        }
        ArrayList<ao> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = El.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ao aoVar = new ao();
                aoVar.width = next.Eq().getWidth();
                aoVar.height = next.Eq().getHeight();
                aoVar.Ri = next.Eq().Ey();
                aoVar.Vx = 17;
                arrayList.add(aoVar);
            } else if (next.Eu() != null) {
                ao aoVar2 = new ao();
                aoVar2.width = next.Eu().alT.alx;
                aoVar2.height = next.Eu().alT.aly;
                aoVar2.Vy = next.Eu();
                aoVar2.Vx = 20;
                arrayList.add(aoVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.csn) {
                break;
            }
            arrayList.addAll(this.csl.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ao aoVar3 = new ao();
            aoVar3.Ri = this.bimg_url;
            aoVar3.width = 105;
            aoVar3.width = 105;
            aoVar3.Vx = 19;
            arrayList.add(aoVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ao aoVar4 = new ao();
        aoVar4.Ri = this.author.getPortrait();
        aoVar4.Vx = 12;
        arrayList.add(aoVar4);
        if (this.csl != null) {
            Iterator<j> it2 = this.csl.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return cse;
    }

    public boolean aoJ() {
        return this.csj;
    }

    public void fg(boolean z) {
        this.csj = z;
    }
}
