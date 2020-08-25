package com.baidu.tieba.tbadkCore.data;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PaymentConfirmRequestData implements Serializable {
    public static final String TERMINAL_ANDROID = "320";
    private static final long serialVersionUID = 5867821330520807722L;
    private long goods_duration;
    private String goods_name;
    private long goods_num;
    private String goods_pic;
    private String goods_unit;
    private int goods_user_level;
    private long open_id;
    private String order_id;
    private int pay_type;
    private long scene_id;
    private long tdou_num;
    private String terminal;

    public long getTdou_num() {
        return this.tdou_num;
    }

    public void setTdou_num(long j) {
        this.tdou_num = j;
    }

    public long getOpen_id() {
        return this.open_id;
    }

    public void setOpen_id(long j) {
        this.open_id = j;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public long getScene_id() {
        return this.scene_id;
    }

    public void setScene_id(long j) {
        this.scene_id = j;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String str) {
        this.goods_name = str;
    }

    public String getGoods_pic() {
        return this.goods_pic;
    }

    public void setGoods_pic(String str) {
        this.goods_pic = str;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public long getGoods_num() {
        return this.goods_num;
    }

    public void setGoods_num(long j) {
        this.goods_num = j;
    }

    public String getGoods_unit() {
        return this.goods_unit;
    }

    public void setGoods_unit(String str) {
        this.goods_unit = str;
    }

    public long getGoods_duration() {
        return this.goods_duration;
    }

    public void setGoods_duration(long j) {
        this.goods_duration = j;
    }

    public int getGoods_user_level() {
        return this.goods_user_level;
    }

    public void setGoods_user_level(int i) {
        this.goods_user_level = i;
    }

    public int getPay_type() {
        return this.pay_type;
    }

    public void setPay_type(int i) {
        this.pay_type = i;
    }
}
