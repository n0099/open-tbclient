package com.baidu.tieba.kn.ladders;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class KnLaddersModel extends com.baidu.adp.a.c implements Serializable {
    public static final int LOCAL_CACHE_EXPIRED_TIME = 86400000;

    /* renamed from: a  reason: collision with root package name */
    private static o f1209a = null;
    static final long serialVersionUID = 323412341;
    @SerializedName("mainbar")
    public MainBar mainbar;
    @SerializedName("rank_info")
    public RankInfo[] rank_info;
    @SerializedName("rank_page_info")
    public RankPageInfo rank_page_info;

    /* loaded from: classes.dex */
    public class Name implements Serializable {
        static final long serialVersionUID = 843094;
        @SerializedName("ranking_name")
        public String ranking_name = "";
        @SerializedName("ranking_type")
        public int ranking_type = 1;
    }

    /* loaded from: classes.dex */
    public class Pic implements Serializable {
        static final long serialVersionUID = 323412341212L;
        @SerializedName("pic_id")
        public int pic_id = 0;
        @SerializedName("pic_url")
        public String pic_url = "";
        @SerializedName("link_url")
        public String link_url = "";
        @SerializedName("note")
        public String note = "";
        @SerializedName("last_update_date")
        public String last_update_date = "";
        @SerializedName("is_valid")
        public int is_valid = 1;
    }

    /* loaded from: classes.dex */
    public class RankPageInfo implements Serializable {
        static final long serialVersionUID = 87038431;
        @SerializedName("names")
        public Name[] names;
        @SerializedName("pics")
        public Pic[] pics;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    /* loaded from: classes.dex */
    public class MainBar implements Serializable {
        static final long serialVersionUID = 788934032;
        @SerializedName("offline")
        public int offline = 0;
        @SerializedName("title")
        public String title = "";
        @SerializedName("link")
        public String link = "";

        public String toString() {
            return "MainBar{offline=" + this.offline + ", title='" + this.title + "', link='" + this.link + "'}";
        }
    }

    /* loaded from: classes.dex */
    public class RankInfo implements Serializable {
        static final long serialVersionUID = 94310471;
        @SerializedName("players")
        public PlayerInfo[] players;
        @SerializedName("ranking_type")
        public int ranking_type = 1;

        public String toString() {
            return "RankInfo{ranking_type=" + this.ranking_type + ", players=" + Arrays.toString(this.players) + '}';
        }
    }

    /* loaded from: classes.dex */
    public class PlayerInfo implements Serializable {
        public static final int ENIMINATED = 0;
        public static final int JOIN_TYPE_HSY = 2;
        public static final int JOIN_TYPE_KN = 1;
        public static final int NOT_ENIMINATED = 1;
        static final long serialVersionUID = 31221058498L;
        @SerializedName("player_id")
        public int player_id = 0;
        @SerializedName("player_name")
        public String player_name = "";
        @SerializedName("small_head_url")
        public String small_head_url = "";
        @SerializedName("big_head_url")
        public String big_head_url = "";
        @SerializedName("forum_name")
        public String forum_name = "";
        @SerializedName("forum_id_list")
        public String forum_id_list = "";
        @SerializedName("member_num")
        public String member_num = "";
        @SerializedName("vote_number")
        public long vote_number = 0;
        @SerializedName("vote_times")
        public long vote_times = 0;
        @SerializedName("join_type")
        public int join_type = 1;
        @SerializedName("living")
        public int living = 1;

        public String toString() {
            return "PlayerInfo{player_id=" + this.player_id + ", player_name='" + this.player_name + "', small_head_url='" + this.small_head_url + "', big_head_url='" + this.big_head_url + "', forum_name='" + this.forum_name + "', forum_id_list='" + this.forum_id_list + "', member_num='" + this.member_num + "', vote_number=" + this.vote_number + ", vote_times=" + this.vote_times + ", join_type=" + this.join_type + ", living=" + this.living + '}';
        }
    }

    public static synchronized void fetch(Context context, q qVar, boolean z) {
        synchronized (KnLaddersModel.class) {
            if (f1209a == null || f1209a.getStatus() != BdAsyncTask.BdAsyncTaskStatus.RUNNING) {
                f1209a = new o(context, qVar, z);
                f1209a.execute(new Void[0]);
            }
        }
    }

    public static synchronized void cancel() {
        synchronized (KnLaddersModel.class) {
            if (f1209a != null) {
                f1209a.cancel();
                f1209a = null;
            }
        }
    }
}
