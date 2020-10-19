package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements q, ah {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private TbRichTextVoiceInfo eIX;
    private List<HeadItem> enB;
    private OriginalThreadInfo erY;
    private SkinInfo ers;
    private String erv;
    private Item esP;
    private String kVc;
    public int locate;
    private SmallTailInfo lru;
    private com.baidu.tbadk.data.c mEA;
    private com.baidu.tbadk.data.f mEB;
    private i mEE;
    private bs mEF;
    public boolean mEH;
    private com.baidu.tbadk.widget.richText.j mEI;
    private String mEJ;
    private String mEK;
    private TPointPost mEL;
    public int mEO;
    public boolean mER;
    public AlaLiveInfoCoreData mEU;
    private boolean mEY;
    private String mEp;
    private ArrayList<PostData> mEt;
    public aq mFc;
    public List<PbContent> mFg;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId mEg = BdUniqueId.gen();
    public static final BdUniqueId mEh = BdUniqueId.gen();
    public static final BdUniqueId ert = BdUniqueId.gen();
    public static final BdUniqueId epC = BdUniqueId.gen();
    public static final BdUniqueId epH = BdUniqueId.gen();
    public static final BdUniqueId mEi = BdUniqueId.gen();
    public static final BdUniqueId mEj = BdUniqueId.gen();
    public static final BdUniqueId mEk = BdUniqueId.gen();
    public static final BdUniqueId mEl = BdUniqueId.gen();
    public static final BdUniqueId mEm = BdUniqueId.gen();
    public static boolean mEn = false;
    private int mEo = 0;
    private boolean mEu = false;
    private ArrayList<PostData> mEv = null;
    private TbRichText mEw = null;
    private boolean mEz = false;
    private boolean mEC = false;
    private boolean mED = false;
    public boolean mEG = false;
    public int eqR = 0;
    private boolean mEM = false;
    public boolean ixR = false;
    public boolean mEN = false;
    public boolean mEP = false;
    public boolean mEQ = true;
    public boolean mES = false;
    public boolean mET = false;
    private boolean mEV = false;
    private int mEW = 0;
    private boolean mEX = true;
    public boolean mEZ = false;
    public boolean mFa = false;
    public boolean mFb = false;
    public boolean mFe = false;
    public boolean mFf = false;
    private b mFh = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.mFc != null) {
                aq bmQ = PostData.this.mFc.bmQ();
                bmQ.delete("obj_locate");
                bmQ.aj("obj_locate", 7);
                TiebaStatic.log(bmQ);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData equ = new MetaData();
    private ArrayList<l> mEq = new ArrayList<>();
    private ArrayList<l> mEr = new ArrayList<>();
    private int mEs = 0;
    private int erc = 0;
    private PraiseData eqF = new PraiseData();
    private ax mEx = new ax();
    private c mEy = new c();
    private ArrayList<com.baidu.tbadk.data.c> ero = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.mEt = null;
        this.mEO = 0;
        this.mEt = new ArrayList<>();
        this.mEO = 0;
    }

    public void wQ(boolean z) {
        this.mEY = z;
    }

    public boolean dEh() {
        return this.mEY;
    }

    public ArrayList<PostData> dEi() {
        return this.mEv;
    }

    public void dEj() {
        this.mEv.clear();
        this.mEv = null;
        this.mEu = false;
    }

    public void w(PostData postData) {
        if (postData != null) {
            if (this.mEv == null) {
                this.mEv = new ArrayList<>();
                if (y.getCount(this.mEt) > 2) {
                    this.mEv.addAll(y.subList(this.mEt, 0, 2));
                } else {
                    this.mEv.addAll(this.mEt);
                }
            }
            this.mEv.add(postData);
        }
    }

    public void x(PostData postData) {
        if (postData != null && this.mEt != null) {
            this.mEt.add(postData);
            dEn();
        }
    }

    public void Sb(String str) {
        if (this.mEv != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.mEv.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.mEv.remove(next);
                    return;
                }
            }
        }
    }

    public void wR(boolean z) {
        this.mEX = z;
    }

    public boolean dEk() {
        return this.mEX;
    }

    public void wS(boolean z) {
        this.mEu = z;
    }

    public boolean dEl() {
        return this.mEu;
    }

    public ArrayList<PostData> dEm() {
        return this.mEt;
    }

    public void dEn() {
        this.mEs++;
    }

    public void dEo() {
        this.mEs--;
    }

    public void IX(int i) {
        this.mEs = i;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dEp() {
        return this.floor_num;
    }

    public void IY(int i) {
        this.floor_num = i;
    }

    public boolean dEq() {
        return this.mED;
    }

    public void wT(boolean z) {
        this.mED = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = at.getFormatTime(j);
    }

    public MetaData bih() {
        return this.equ;
    }

    public void a(MetaData metaData) {
        this.equ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.eqF = praiseData;
    }

    public TbRichText dEr() {
        return this.mEw;
    }

    public void c(TbRichText tbRichText) {
        this.mEw = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo dkx() {
        return this.lru;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.lru = smallTailInfo;
    }

    public com.baidu.tbadk.data.f dEs() {
        return this.mEB;
    }

    public SkinInfo biD() {
        return this.ers;
    }

    public void wU(boolean z) {
        this.mEV = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.mEw != null && this.mEw.bBq() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.equ != null && this.equ.getIs_bawu() == 1) {
                    if (this.mEY) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.equ.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.equ.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.equ.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.equ.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = bih().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mS().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.e.c.mS().a(next.getIcon(), 21, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.e.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.mEw.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.equ.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.equ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.equ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.equ.getName_show() + str + "：");
                str2 = this.equ.getUserName();
                str3 = this.equ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.equ.getSealPrefix())) {
                Bitmap bitmap = ap.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.equ.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.mFh), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.equ != null && this.equ.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.b e = e(z, this.equ != null && this.equ.getIs_bawu() == 1, str);
                if (e != null) {
                    if (this.equ != null) {
                        int i3 = 0;
                        if (this.equ.getName_show() != null) {
                            i3 = this.equ.getName_show().length();
                        }
                        spannableString.setSpan(e, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> bBq = this.mEw.bBq();
            if (bBq != null && bBq.size() > 0) {
                TbRichTextData tbRichTextData2 = bBq.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.bBx() != null) {
                    if (this.mEV) {
                        int indexOf = tbRichTextData2.bBx().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.bBx().delete(0, indexOf + 1);
                        }
                        this.mEV = false;
                    }
                    tbRichTextData2.se(sb.length());
                    tbRichTextData2.bBx().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bBq.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (bBq.get(i5) == null || bBq.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo bBy = bBq.get(i5).bBy();
                            bBq.remove(i5);
                            tbRichTextVoiceInfo = bBy;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.se(sb.length());
                    tbRichTextData.o(spannableString);
                    bBq.add(0, tbRichTextData);
                }
            }
            this.mEZ = true;
        }
    }

    private com.baidu.tbadk.core.view.b e(boolean z, boolean z2, String str) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        bVar.iO(true);
        if (" 吧主".equals(str) || " 小吧主".equals(str) || " 楼主".equals(str) || " 品牌官".equals(str)) {
            bVar.pi(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6));
            bVar.BH(str);
            return bVar;
        }
        return bVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public int dEt() {
        return this.mEs;
    }

    public void fR(Context context) {
        int type;
        int i;
        int i2;
        if (this.mEq != null) {
            int i3 = -1;
            int size = this.mEr.size();
            if (size > 0) {
                try {
                    i3 = this.mEr.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.mEq.size()) {
                l lVar = this.mEq.get(i4);
                if (l.dp(i5, lVar.getType())) {
                    this.mEr.get(size - 1).b(lVar.fQ(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.mEr.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.fQ(context));
                        this.mEr.add(lVar2);
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

    public void fS(Context context) {
        try {
            if (this.mEw != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.mEw.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.mEr == null || this.mEr.size() == 0) {
                fR(context);
            }
            ArrayList<l> arrayList = this.mEr;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.dDZ() != null) {
                            sb.append((CharSequence) next.dDZ());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String CY = TbFaceManager.bwK().CY(next.getText());
                        if (CY != null) {
                            sb.append("[");
                            sb.append(CY);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !at.isEmpty(next.dDY())) {
                        sb.append("[").append(next.dDY()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
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
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.mEC = subPostList.is_giftpost.intValue() == 1;
                this.agreeData.postId = this.id;
                this.agreeData.parseProtobuf(subPostList.agree);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.equ = metaData;
                }
                if (this.equ.getUserId() == null || this.equ.getUserId().length() <= 0 || this.equ.getUserId().equals("0")) {
                    this.equ = metaData2;
                }
                this.mEw = TbRichTextView.a(context, subPostList.content, z);
                if (this.mEw != null) {
                    this.mEw.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        TbRichTextData tbRichTextData;
        int i;
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = at.getFormatTime(this.time);
                this.mEp = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.equ = metaData;
                }
                this.ixR = post.need_log.intValue() == 1;
                this.mEN = post.img_num_abtest.intValue() == 1;
                this.mEF = new bs();
                this.mEF.parserProtobuf(post.from_forum);
                if (this.equ.getUserId() == null || this.equ.getUserId().length() <= 0 || this.equ.getUserId().equals("0")) {
                    this.equ.parserProtobuf(post.author);
                }
                if (this.equ != null && context != null) {
                    this.mEJ = this.equ.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.mEK = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.equ.getLevel_id()));
                }
                this.mEz = post.is_ntitle.intValue() == 1;
                this.mEs = post.sub_post_number.intValue();
                this.mEE = new i(post.tpoint_post);
                List<PbContent> list = post.content;
                this.mFg = post.content;
                this.mFe = post.is_wonderful_post.intValue() == 1;
                this.mFa = post.is_top_agree_post.intValue() == 1;
                this.enB = post.item_star;
                if (post.item != null && post.item.item_id.longValue() != 0) {
                    this.esP = post.item;
                }
                this.mEw = TbRichTextView.a(context, list, true);
                if (this.mEw != null) {
                    this.mEw.setPostId(com.baidu.adp.lib.f.b.toLong(this.id, -1L));
                    this.mEw.sd(this.floor_num);
                    if (this.equ != null) {
                        this.mEw.setAuthorId(this.equ.getUserId());
                    }
                    int count = y.getCount(this.enB);
                    if (this.floor_num == 1 && count != 0 && this.enB != null) {
                        ArrayList<TbRichTextData> bBq = this.mEw.bBq();
                        if (count == 1) {
                            TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bBq, 0);
                            if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                                TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                                y.add(bBq, 0, tbRichTextData3);
                                tbRichTextData = tbRichTextData3;
                            } else {
                                tbRichTextData = tbRichTextData2;
                            }
                            HeadItem headItem = (HeadItem) y.getItem(this.enB, 0);
                            if (headItem != null) {
                                try {
                                    i = Integer.parseInt(headItem.content);
                                } catch (NumberFormatException e) {
                                    i = 0;
                                }
                                tbRichTextData.p(com.baidu.tbadk.widget.richText.e.I(i, false));
                            }
                        } else {
                            for (int size = this.enB.size() - 1; size >= 0; size--) {
                                HeadItem headItem2 = this.enB.get(size);
                                if (headItem2 != null) {
                                    a(bBq, headItem2);
                                }
                            }
                        }
                    }
                    if (this.floor_num == 1 && this.esP != null) {
                        TbRichTextData tbRichTextData4 = new TbRichTextData(1281);
                        tbRichTextData4.a(new TbRichTextEvaluateItemInfo(this.esP));
                        y.add(this.mEw.bBq(), tbRichTextData4);
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list2 = subPost.sub_post_list;
                    if (list2.size() > 0) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            SubPostList subPostList = list2.get(i2);
                            PostData postData = new PostData();
                            postData.mEC = subPostList.is_giftpost.intValue() == 1;
                            postData.agreeData.parseProtobuf(subPostList.agree);
                            postData.setUserMap(this.userMap);
                            postData.wQ(this.mEY);
                            postData.a(subPostList, context);
                            this.mEt.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.mEy.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.mEA = new com.baidu.tbadk.data.c();
                    this.mEA.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.mEB = new com.baidu.tbadk.data.f();
                    this.mEB.a(post.lbs_info);
                }
                this.erc = post.storecount.intValue();
                this.mEx.a(post.present);
                this.eqF.setUserMap(this.userMap);
                this.eqF.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.lru = new SmallTailInfo();
                    this.lru.id = post.signature.signature_id.intValue();
                    this.lru.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.lru.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.lru.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.lru.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i3));
                        this.ero.add(cVar);
                    }
                }
                this.ers = post.skin_info;
                this.erv = post.lego_card;
                this.mEL = post.tpoint_post;
                if (post.agree != null) {
                    this.mEM = true;
                    this.agreeData.postId = this.id;
                    this.agreeData.parseProtobuf(post.agree);
                } else {
                    this.mEM = false;
                }
                this.mET = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.erY = new OriginalThreadInfo();
                    this.erY.a(post.origin_thread_info);
                } else {
                    this.erY = null;
                }
                this.mEW = post.is_fold.intValue();
                this.kVc = post.fold_tip;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) com.baidu.tbadk.widget.richText.e.I(i, true));
        }
        tbRichTextData.o(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(this.mColorId));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> mFn;
        private b mFo;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.mFn = new SoftReference<>(context);
            this.mFo = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.mFn != null && this.mFn.get() != null) {
                if (this.mFo != null) {
                    this.mFo.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mFn.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String fT(Context context) {
        ArrayList<TbRichTextData> bBq;
        if (this.mEw == null || (bBq = this.mEw.bBq()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = bBq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.bBx().toString());
            } else if (next.getType() == 17) {
                String str = next.bBB().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String dEu() {
        ArrayList<TbRichTextData> bBq;
        String str;
        if (this.mEw == null || (bBq = this.mEw.bBq()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = bBq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.bBx().toString());
                } else if (next.getType() == 17) {
                    if (next.bBB() != null && next.bBB().mGifInfo != null && (str = next.bBB().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo dEv() {
        ArrayList<TbRichTextData> bBq;
        if (this.mEw != null && (bBq = this.mEw.bBq()) != null) {
            Iterator<TbRichTextData> it = bBq.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.bBw().getWidth();
                    preLoadImageInfo.height = next.bBw().getHeight();
                    preLoadImageInfo.imgUrl = next.bBw().bBM();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.bBC().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.bBC().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.bBC().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String dEw() {
        k dDW;
        PreLoadImageInfo dEv = dEv();
        if (dEv != null && !StringUtils.isNull(dEv.imgUrl)) {
            return dEv.imgUrl;
        }
        if (this.mEE != null && (dDW = this.mEE.dDW()) != null && !StringUtils.isNull(dDW.dDX())) {
            return dDW.dDX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> bBq;
        if (this.mEw == null || (bBq = this.mEw.bBq()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = bBq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.bBw().getWidth();
                preLoadImageInfo.height = next.bBw().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bBw().bBR()) {
                    preLoadImageInfo.imgUrl = next.bBw().bBN();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.bBw().bBM();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.bBB() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.bBB().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.bBB().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.bBB();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.equ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.equ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.mEo == 52) {
            return mEk;
        }
        if (this.mEo == 1) {
            return ert;
        }
        if (this.mEo == 36) {
            return epC;
        }
        if (this.mEo == 40 || this.mEo == 50) {
            return epH;
        }
        if (this.mEo == 41) {
            return mEi;
        }
        if (this.mEo == 53) {
            return mEl;
        }
        if (dEp() == 1) {
            return mEg;
        }
        return mEh;
    }

    public void setPostType(int i) {
        this.mEo = i;
    }

    public ax dEx() {
        return this.mEx;
    }

    public void a(ax axVar) {
        this.mEx = axVar;
    }

    public i dEy() {
        return this.mEE;
    }

    public com.baidu.tbadk.widget.richText.j bBA() {
        if (this.mEI != null) {
            return this.mEI;
        }
        if (this.mEw != null && y.getCount(this.mEw.bBq()) > 0) {
            Iterator<TbRichTextData> it = this.mEw.bBq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.mEI = next.bBA();
                    return this.mEI;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo bBy() {
        if (this.eIX != null) {
            return this.eIX;
        }
        if (this.mEw != null && y.getCount(this.mEw.bBq()) > 0) {
            Iterator<TbRichTextData> it = this.mEw.bBq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.eIX = next.bBy();
                    return this.eIX;
                }
            }
        }
        return null;
    }

    public String dEz() {
        return this.mEJ;
    }

    public String bjr() {
        return this.erv;
    }

    public void bjt() {
        if (this.eqR == 0) {
            this.eqR = 1;
        }
    }

    public long bjG() {
        return this.agreeData.disAgreeNum;
    }

    public int bjI() {
        return this.agreeData.agreeType;
    }

    public AgreeData bjY() {
        return this.agreeData;
    }

    public OriginalThreadInfo dEA() {
        return this.erY;
    }

    public void h(OriginalThreadInfo originalThreadInfo) {
        this.erY = originalThreadInfo;
    }

    public int dEB() {
        return this.mEW;
    }

    public String dcL() {
        return this.kVc;
    }
}
